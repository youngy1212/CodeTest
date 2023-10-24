
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Memories_score {


    /*
     * 문제 : 사진속에 나오는 인물의 그리움 점수를 모두 합산한 값이 추억 점수가 됩니다.
     * 예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다.
     *그리워하는 사람의 이름을 담은 문자열 배열 name, 각 사람별 그리움 점수를 담은 정수 배열 yearning, 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때, 
     * 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.
     */


    public static int[] memories_score(String[] name, int[] yearning, String[][] photo) {
      
        //인물 hashMap 이름, 점수로 이루어짐.
        Map<String,Integer> map = new HashMap<>();

        for(int i =0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];
        //사진점수 계산
        for(int i =0; i<photo.length; i++){
            int totalYearning = 0; 
            for(String person : photo[i]){ //photo 반복으로 점수 체크
                totalYearning += map.getOrDefault(person,0);
            }

            result[i] = totalYearning;

        }
    
        return result;
    }


    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};

        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        
        int[] answer = memories_score(name,yearning,photo);
        System.out.println(Arrays.toString(answer));
    }
    
}
