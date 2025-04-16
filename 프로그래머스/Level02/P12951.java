public class P12951 {
    
    //입력 : 문자 s, 1<s<200
    //로직 : 빈기준으로 나눠서 앞자리만 대문자로 변경, 나머지는 소문자로 변경
    //출력 : s를 JadenCase로 바꿔 리턴 

    public String solution(String s) {

        String answer = "";
        String[] arr = s.toLowerCase().split("");

        boolean flag = true;

        for(String ss : arr){
            answer += flag? ss.toUpperCase() : ss;
            flag = ss.equals(" ")? true : false;
        }

        return answer;

    }

}
