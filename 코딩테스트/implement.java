import java.util.Scanner;

public class implement {

    


    public static void main(String[] args) {
       

    }
    
    //상하좌우 
    //명령에 따라 이동한다. 여행지도를 넘어가는 움직임은 무시된다. 
    //입력 : 첫째줄에 공간의크기 N , 두번째줄에 A가 이동할 이동계획서가 주어진다. 
    //로직 : 미리 dx, dy 좌표를 생성하고 L R U D 에 따라서 좌표를 변경하한다. 1 미만의 경우 제외 
    //출력 : 마지막 도착지의 x,y 좌표를 출력 
    static void 상하좌우(){

        //입력
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1; //시작 좌표

        //이동방향에 따른 좌표 이동 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        //로직
        for(int i =0; i<plans.length; i++){
            char plan = plans[i].charAt(0);

            //이동후 좌표
            int nx = -1, ny = -1;
            for(int j =0; j<4; j++ ){
                if(plan == moveTypes[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            // 공간을 벗어나는 경우 무시 
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행 
            x = nx;
            y = ny;
        }

    
        System.out.println(x+" "+y);
    }

     
    //왕실의 나이트
    //L자 형태로만 이동할 수 있으며, 체스판 밖으로는 나갈 수 없다.
    //특정한 위치에서 다음과 같이 2가지로 이동 가능 
    // 1.수평으로 두칸 이동한 뒤에 수직으로 한 칸 이동하기
    // 2.수직으로 두칸 이동한 뒤 수평으로 한 칸 이동하기
    //입력 : 
    //로직 : 나이트가 이동할 수 있는 상화좌우의 1,2 번 이동 좌표를 생성하고 완탐으로 대입해본다. 
    //출력 : 이동 가능한 카운트 수 출력 
    static void 왕실의나이트(){

        //입력
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0'; //문자를 정수형 변환
        int column = inputData.charAt(0) - 'a' + 1; //문자를 정수형 변환 

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }

        System.out.println(result);
    }
    

    // 게임 개발
    // 맵 각 칸은 (A,B) 로 나타낼 수 있고, A는 북쪽으로 떨어진 칸의 개수, B는 서쪽으로 떨어진 칸의 개수
    // 캐릭터는 상하좌우 움직을 수 있고, 바다로 되어있는 공간에는 갈수없다. 
    // 왼쪽 바향으로 아직 가보지 않은 곳이 있다면, 왼쪽 방향으로 횐전을 수행하고 한칸 전진
    // 가보지 않은 칸이 없다면 왼쪽 방향으로 회전만 수행하고 다시 1단계로 돌아간다. 
    // 네방향이 이미 가본칸이거나 바다로 되어있다면 방향 유지하고 뒤로 한칸

    //입력 : 첫줄에 맵 크기, 두번째 줄 캐릭터의 위치, 방향 , 세번째부터 맵 
    //로직 : 구현 
    //출력 : 방문핰 방의 수 

    public static int n, m, x, y, direction;

    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];
    // 전체 맵 정보
    public static int[][] arr = new int [50][50];

    // 북, 동, 남, 서 방향 정의
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    static void 게임개발(){

        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        
        // 현재 캐릭터의 X 좌표, Y 좌표, 방향을 입력받기
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1; // 현재 좌표 방문 처리

        // 전체 맵 정보를 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 시뮬레이션 시작
        int cnt = 1;
        int turn_time = 0;
        while (true) {
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else turn_time += 1;
            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
                turn_time = 0;
            }
        }

        System.out.println(cnt);
       
    }

      // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }
    
    
}
