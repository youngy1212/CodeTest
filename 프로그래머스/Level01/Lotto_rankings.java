import java.util.Arrays;

public class Lotto_rankings {
    
    /**
     * 로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권
     * 1	6개 번호가 모두 일치
        2	5개 번호가 일치
        3	4개 번호가 일치
        4	3개 번호가 일치
        5	2개 번호가 일치
        6(낙첨)	그 외
     * 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다. 
     * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고
     * 알아볼 수 없는 번호를 0으로 표기
     * 
     * @param lottos 민우가 구매한 로또 번호를 담은 배열 lottos,
     * @param win_nums 당첨 번호를 담은 배열 win_nums
     * @return 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 
     */


    public static int[] lotto_rankings(int[] lottos, int[] win_nums) {


        int zeroCount = 0; //지워진 숫자 갯수
        int matchNum = 0; //맞는 숫자

        for(int lottoNum : lottos){
           if(lottoNum == 0){
                zeroCount++;
           }else{
            //로또 번호 체크
                for(int winNum : win_nums){
                    if(lottoNum == winNum){
                        matchNum++;
                        break;
                    }
                }
           }
        }


        int[] answer = {0,0};
        answer[0] = getRank(zeroCount+matchNum); //최대
        answer[1] = getRank(matchNum); //최소


        return answer;
    }

    //랭크반환 함수
    private static int getRank(int count) {
        if (count == 6) {
            return 1;
        } else if (count == 5) {
            return 2;
        } else if (count == 4) {
            return 3;
        } else if (count == 3) {
            return 4;
        } else if (count == 2) {
            return 5;
        } else {
            return 6;
        }
    }

    public static void main(String[] args) {
        
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] answer = lotto_rankings(lottos,win_nums);
        System.out.println(Arrays.toString(answer));
    }



}
