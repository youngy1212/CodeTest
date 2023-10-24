import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Change_text {

    /**
     * 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
     * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
     * 478 → "one4seveneight"
     * 234567 → "23four5six7"
        10203 → "1zerotwozero3"
     * 
     * @param s  숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수
     * @return s가 의미하는 원래 숫자를 return
     */

    public static int change_text(String s) {

        //변환되는 언어
         Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        for (String key : numberMap.keySet()) { //Map의 키를 하나씩 문자열을 뽑아서 확인- 변경!
            s = s.replaceAll(key, Integer.toString(numberMap.get(key))); //해당 숫자 값을 문자열로 변환하여 대체
        }

        //replaceAll(String regex, String replacement)

        return Integer.parseInt(s); //모든 숫자를 다시 문자로 파싱하여 전달!
    }

    public static void main(String[] args) {
        int answer = change_text("one4seveneight");
        System.out.println(answer);
    }



}
