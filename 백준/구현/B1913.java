import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B1913 {


    //배열을 탐색할 방향 하-> 우 -> 상 -> 좌 
    static int[] dr = {1, 0, -1,0};
    static int[] dc = {0,1,0,-1};
    static int map[][]; //맵 

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int kr = 0, kc = 0;

        makeMap(n);

        for(int i = 0; i<map.length; i++){

            for(int j = 0; j < map.length; j++){
                sb.append(map[i][j]).append(" ");
                if(map[i][j] == k){
                    kr = i;
					kc = j;
                }
            }
            sb.append("\n");
        }

        sb.append(kr+1).append(" ").append(kc+1);
        System.out.println(sb);

        
    }

    // 달팽이 방향과 거꾸로 삽입
    private static void makeMap(int n) {

        int r = 0;
        int c = 0 ;
        int count = n*n; //전체 숫자 
        int d = 0; //방향

        while (true) {

            if(count == 0){
                break;
            }
            
            map[r][c] = count--;
            int nr = r + dr[d]; 
            int nc = c + dc[d];


            if (nr >= n || nc >= n || nr < 0 || nc < 0 || map[nr][nc] != 0) {
                d = (d + 1) % 4; //방향을 전환
            }

            r = r + dr[d]; //이동
            c = c + dc[d];

         }
        
    }
}
