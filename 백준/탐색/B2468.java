import java.util.*;
import java.io.*;

public class B2468 {
 

    //안전 영역

    //입력 :  N인 2차원 배열 (안에있는 숫자가 높이에 해당)

    //로직 : 배열을 순회하면서 해당지점이 물에 잠기지 않을경우 DFS, 또는 BFS를 호출하여 연결된 모든 
    //안전지역을 방문처리한다.
    // 영역의 개수를 1 증가시킨다.
    
    //출력 : 비에잠기지 않은 안전지역 "최대개수"를 반환 

    static int N;
    static int[][] map;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //입력
        StringTokenizer st;
        map = new int[N][N];

        int max = 0;


        //배열 순회
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
                max = Math.max(map[i][j], max);
            }
        }

        int cnt = 0;
        int maxCount = 0;
       
        for(int waterLevel = 0; waterLevel <= max; waterLevel++){
            checked = new boolean[N][N]; 
            cnt = 0;

            for(int i = 0; i <N; i++){
                for(int j = 0; j <N; j++){
                    if(map[i][j] > waterLevel && !checked[i][j]){
                        checked[i][j] = true; 
                        dfs(i,j,waterLevel);
                        cnt++;
                    }
                }
            }

            maxCount = Math.max(cnt,maxCount);
            
        }

        System.out.println(maxCount);
      
    }

    public static void dfs(int x, int y, int waterLevel) { 
        int[] ud = {1, -1, 0, 0};
        int[] lr = {0, 0, 1, -1};

        for(int i = 0; i < 4; i++) {
            int newX = x + ud[i];
            int newY = y + lr[i];

            // 범위 체크
            if(newX < 0 || newY < 0 || newX >= N || newY >= N) {
                continue;
            }

            if(!checked[newX][newY] && map[newX][newY] > waterLevel) {
                checked[newX][newY] = true;
                dfs(newX, newY,waterLevel );
            }
        }

    }
}
