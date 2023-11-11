import java.io.*;
import java.util.*;


public class B1260 {

    //받아올 변수
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] arr;

    static int node, line, start;
    
    public static void main(String[] args) throws IOException {

        //받아옴 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        

        //arr 
        arr = new int[node+1][node+1];

        visited = new boolean[node + 1];

        //정보 입력
        for(int i = 0; i<line; i++ ){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] =  1;	
        }

        

        dfs(start);
        sb.append("\n");


        // visited 배열 초기화
        visited = new boolean[node+1];
       
        bfs(start);
        sb.append("\n");

        System.out.println(sb);

    }

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start+" ");

        //재귀호출
        for(int i = 0; i <= node; i++){
            if(arr[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start+" ");

            for(int i = 1; i <=node; i++){
                if(!visited[i] && arr[start][i] == 1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

   
}