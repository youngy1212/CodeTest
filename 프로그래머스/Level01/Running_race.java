
import java.util.*;

public class Running_race {

    /*
     * 문제 : 얀에서는 매년 달리기 경주가 열립니다. 
     * 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 
     * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 
     * 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 
     * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return하시오.
     */

     /* 해설 Hash Map을 사용한 방법 O(N) 시간 복잡도를 가진다.
      * map에 있는 등수와 players에 있는 등수를 다 변경해주어야 함
      * 그렇기 떄문에 이 코드의 시간 복잡도는 O(n+m)입니다. 
     */


    public static String[] running_race(String[] players, String[] callings) {
  
        //1. 선수와 이름과 현재 위치를 Map에 저장합니다.
        Map<String, Integer> playersMap  = new HashMap<>();
        for(int i = 0; i<players.length; i++ ){
            playersMap.put(players[i], i);
        }
        
        for(String calling : callings){

            //등수 호출
            int rank = playersMap.get(calling);

            //앞서 가던 선수 호출
            String beforePlyer = players[rank-1];

            //player 배열 갱신
            players[rank-1] = calling;
            players[rank] = beforePlyer;

            //rankMap 갱신
            playersMap.put(beforePlyer, rank);
            playersMap.put(calling, rank-1);

        }

        return players;

    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] answer = running_race(players, callings);
        System.out.println(Arrays.toString(answer));
    }
    
    
}
