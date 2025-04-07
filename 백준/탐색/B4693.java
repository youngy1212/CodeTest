import java.util.*;


public class B4693 {

    static int[][] map;
    static boolean[][] check;
    static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    static int w, h, nowX, nowY;

    //입력 : 지도의 너버 w 높이 h 
    // 0 < w <= 50  
    // 두번쨰 줄 h개의 줄에는 지도가 주어진다. 1 땅 0 바다
    // 입력 마지막 줄에는 00이 두개 주어진다.

    // 로직 :  대각선까지 포함하여 계산한다.
    // DFS 탐색을 그대로 사용하는데, 상하좌우+대각선까지 8번 dfs 

    //출략 : 섬의 개수를 출력한다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt(); // 너비 입력
            h = sc.nextInt(); // 높이 입력

            // 종료 조건: 너비와 높이가 모두 0일 경우 종료
            if (w == 0 && h == 0) {
                break;
            }

            // 지도와 방문 여부 배열 초기화
            map = new int[h][w];
            check = new boolean[h][w];

            // 지도 데이터 입력
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0; // 섬의 개수

            // 섬 탐색
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        DFS(i, j); // DFS 호출
                        count++; // 섬 개수 증가
                    }
                }
            }

            // 결과 출력
            System.out.println(count);
        }

        sc.close();
    }

    // DFS로 섬 탐색
    static void DFS(int x, int y) {
        check[x][y] = true; // 현재 위치 방문 처리

        for (int i = 0; i < 8; i++) { // 8방향 탐색
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            // 지도 범위 내에 있고, 땅이며, 아직 방문하지 않은 경우
            if (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w) {
                if (map[nowX][nowY] == 1 && !check[nowX][nowY]) {
                    DFS(nowX, nowY); // 재귀 호출
                }
            }
        }
    }
}
