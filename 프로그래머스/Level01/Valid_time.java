
import java.util.*;


public class Valid_time {

    /**
     * 고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 
     * 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다
     * 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.
     * @param today : 오늘 날짜 "YYYY.MM.DD" 
     * @param terms : 약관의 유효기간을 담은 1차원 문자열 배열 
     * (약관 종류와 유효기간을 공백 하나로 구분한 문자열)
     * @param privacies : 수집된 개인정보의 정보 1차원 문자열 배열
     * (privacies[i]는 i+1번 개인정보의 수집 일자와 약관 종류,privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열)
     * @return   파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열
     */


     /* 주의!! :  String.split() 메소드를 사용할때, '.' 기호는 "\\" 문자열을  escape 문자로 사용해야 한다.*/
    public static int[] valid_time(String today, String[] terms, String[] privacies) {
        
        int len = privacies.length;
        ArrayList<Integer> answerList = new ArrayList<>();

        //terms 을 Map에 넣어줘서 확인하기 쉽도록 변경 
        Map<String, Integer> termDict = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termDict.put(parts[0], Integer.parseInt(parts[1])*28);
        }

        //일자로 계산
        int todayDate = calculateDate(today);


        //비교연산
        for (int i = 0; i < len; i++) {
            String[] parts = privacies[i].split(" ");
            int registrationDate = calculateDate(parts[0])+ termDict.get(parts[1]); //기간
            

            if (todayDate >= registrationDate) { //만료되었다.
                answerList.add(i+1);
            }

        }

        //List 자료형은 Integer이기 떄문에 int[]로 변환해주어야 한다. 

        //트림(Stream) API 
        //.mapToInt(Integer::intValue): 스트림의 각 요소에 대해 지정된 함수를 적용하고, 그 결과를 정수로 변환한 새로운 스트림을 반환
        // .toArray(): 변환된 정수형 스트림을 배열에 담음 
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    //날짜를 일자로 계산 (여러번 사용하니 함수화)
    private static int calculateDate(String date){
        String[] parts =  date.split("\\.");
        return Integer.parseInt(parts[0])*28 * 12+Integer.parseInt(parts[1]) * 28 + Integer.parseInt(parts[2]);
    }

 
    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] answer = valid_time(today,terms, privacies);
        System.out.println(Arrays.toString(answer));
    }
}

    