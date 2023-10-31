public class Game_star {

    /**
     * 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임
     * 다트 게임은 총 3번의 기회로 구성된다. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
      점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산
        옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
        스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
        스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
        스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
        Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
        스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
        0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
            
      * @param dartResult 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열
     * @return 총점수를 반환
     */
    public static int game_star(String dartResult) {

        //문자열 처리
        String[] dart = dartResult.split("");
        int[] score = new int[3];
        int scoreIndex = -1;

        for(int i = 0; i<dart.length; i++){
            //숫자인지 체크

            if(dart[i].matches("[0-9]")) {//숫자인지 체크
                scoreIndex++; 
                if(dart[i+1].equals("0")){ //10점이라면
                   score[scoreIndex] = 10;
                   i++;
                }else{
                   score[scoreIndex] = Integer.parseInt(dart[i]);
                }
            }

            switch(dart[i]) {
                case "*" : 
                    score[scoreIndex] *= 2; //두배!
                    if(scoreIndex - 1 >= 0) score[scoreIndex-1] *= 2; //전도 두배
                    break;
                case "#" :
                    score[scoreIndex] *= -1; //마이너스 
                    break;
                case "D":
                    score[scoreIndex] = (int)Math.pow(score[scoreIndex], 2);//2제곱
                    break;
                case "T":
                    score[scoreIndex] = (int)Math.pow(score[scoreIndex], 3);//3제곱
                    break;
            }

        }

    
        return score[1]+score[2]+score[3];
    }

    public static void main(String[] args) {
        System.out.println(game_star("1S2D*3T"));
    }
}
