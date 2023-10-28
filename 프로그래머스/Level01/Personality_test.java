import java.util.HashMap;

public class Personality_test {


    /**
     * 1번 지표 : 라이언형 R, 투브형 T
     * 2번 지표 : 콘형 C, 프로도형 F
     * 3번 지표 : 제이지형 J, 무지형 M
     * 4번 지표 : 어피치 형 A, 네오형 N
     * -> 성ㄱ겨 유형은 총 16(=2*2*2*2) 나올 수 있습니다.
     * 예) RFMN, TCMA 같은 성격유형이 있습니다.
     * 총 n개의 질문이 있고, 각 질문에는 아래와 같은 7개 선택지 있습니다
     * (매우비동의, 비동의 ......~)
     * 매우동의, 매우 비동의 - 3점
     * 동의, 비동의 - 2점
     * 약간 동의, 약간 비동의 - 1점
     * 모르겠음 0점
     * 
     *. 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 
        두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단 
     *
     * 
     * 
     * 
     * @param survey :질문마다 판단하는 지표를 담은 1차원 문자열 배열
     * @param choices : 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 
     * @return
     */

    public static String personality_test(String[] survey, int[] choices) {

        HashMap<Character, Integer> personalityScores = new HashMap<>();
        personalityScores.put('R', 0);
        personalityScores.put('T', 0);
        personalityScores.put('C', 0);
        personalityScores.put('F', 0);
        personalityScores.put('J', 0);
        personalityScores.put('M', 0);
        personalityScores.put('A', 0);
        personalityScores.put('N', 0);



        final int OFFSET = 4;  // 상수로 오프셋 값 정의


        for(int i =0; i<survey.length; i++ ){
            int value = choices[i];

            if( value < OFFSET) {
                char ch = survey[i].charAt(0);
                personalityScores.put(ch, personalityScores.getOrDefault(ch, 0) + 4 - value);
            } else if(value > OFFSET) {
                char ch = survey[i].charAt(1);
                personalityScores.put(ch, personalityScores.getOrDefault(ch, 0) + value - 4);
            }
        }


    return new StringBuilder()
            .append(personalityScores.getOrDefault('R', 0) >= personalityScores.getOrDefault('T', 0) ? 'R' : 'T')
            .append(personalityScores.getOrDefault('C', 0) >= personalityScores.getOrDefault('F', 0) ? 'C' : 'F')
            .append(personalityScores.getOrDefault('J', 0) >= personalityScores.getOrDefault('M', 0) ? 'J' : 'M')
            .append(personalityScores.getOrDefault('A', 0) >= personalityScores.getOrDefault('N', 0) ? 'A' : 'N')
            .toString();
    }
    



    public static void main(String[] args) {

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        String answer = personality_test(survey, choices);
        System.out.println(answer);
        
    }
}
