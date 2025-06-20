import java.util.LinkedList;
import java.util.Queue;

public class BFSDFS {

    public static void main(String[] args) {

        //음료수 얼려먹기
        //입력 생략
        int result = 0;
        for(int i =0; i < n; i++){
            for(int j =0; j<m; j++){
                //현재 위치에서 DFS 수행
                if(dfs(i, j)){
                    result += 1;
                }
            }
        }

    }
    

    //음료수 얼려먹기기
    //구멍이 뚫려있는 부분끼리 상하좌우 붙어있는 경우 서로 연결된 것으로 간주
    //총 아이스크림 개수를 구하는 프로그램 
    //입력 : 첫줄에 얼음틀 크키, 두번쨰 부터 얼음틀 형태
    //로직 : 상하좌우를 살펴본후 뒤 지점중 값이 0 면서 아직 방문하지 않은 지점이 있으면 다시 방문
    // 방문한 지점에서 상하좌우를 살펴보면서 방문을 다시 진행, 연결된 모든 지점을 방문 
    // DFS 방식을 사용 
    //출력 : 한번에 만들 수 있는 아이스크림 개수

    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    //DFS로 특정 노드를 방문하고 연결된 모든 노드 방문
    public static boolean dfs(int x, int y){

        if(x <= -1 || x >=n || y <= -1 || y >= m ){
            return false;
        }

        //해당 노드를 방문하지 않았다면
        if(graph[x][y] == 0){

            // 노드 방문처리
            graph[x][y] = 1;

            //상하좌우 재귀 호출
            dfs(x-1, y); //상
            dfs(x, y-1); //하
            dfs(x+1, y); //좌
            dfs(x, y+1); //우
            
            return true;
        } 
        return false;
    }

    //미로 탈출
    //괴물이 있는 부분은 0, 괴물이 없는 부분은 1 괴물을 피해서 탈출하는 최소 칸의 개수를 구하시오
    //입력 : N,M 크기, 이후 미로의 정보 
    //로직 : 가까운 시작점에서 차례대로 모든 그래프 탐색 
    // BFS 방식을 사용 
    //출력 : 최송 이동칸의 개수 

    public static int n1, m1;
    public static int[][] graph2 = new int[201][201];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y){

       Queue<Node> q = new LinkedList<>();
       q.offer(new Node(x, y)); 

       //큐가 빌때까지 반복
       while (!q.isEmpty()) {
        Node node = q.poll();
        x = node.getX();
        y = node.getY();

        // 현재 위치에서 4가지 방향으로의 위치 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 미로 찾기 공간을 벗어난 경우 무시
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            // 벽인 경우 무시
            if (graph[nx][ny] == 0) continue;
            // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            if (graph[nx][ny] == 1) {
                graph[nx][ny] = graph[x][y] + 1;
                q.offer(new Node(nx, ny));
            } 
        } 
       }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n1 - 1][m1 - 1];
    }

}

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}
