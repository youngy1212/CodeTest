import java.util.*;
import java.io.*;

public class B2178 {

    public  static int[][] map ;
    public  static boolean[][] visited;
    public  static int n,m;

    public static final int dx[] = {-1,1,0,0};
    public static final int dy[] = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //크기 n,m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        //배열 받아오기
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m]; //방문 체크!
        visited[0][0] = true;//출발
        bfs(0,0);
        System.out.println(map[n-1][m-1]); //가장 마지막 
        
    }

    private static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while (!q.isEmpty()) {

            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i <4; i++){

                int nextX = nowX +dx[i];
                int nextY = nowY +dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                    continue;
                }
                if(visited[nextX][nextY] || map[nextX][nextY] == 0){
                    //방문하거나 벽인 경우
                    continue;
                }

                q.add(new int[]{nextX,nextY});
                map[nextX][nextY] = map[nowX][nowY]+1;
                visited[nextX][nextY] = true;

            }
            
        }

    }
}
