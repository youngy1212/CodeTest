
import java.util.Arrays;

public class Walk_park {

    /**
     * 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 
     * 로봇 강아지가 산책을 하려합니다. 
     * 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.
     * ["방향 거리", "방향 거리" … ]
     * 예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 
     * 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
     * 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
     * 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
     * 위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
     * @param park 공원을 나타내는 문자열 배열 공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 
     * @param routes : 로봇 강아지가 수행할 명령이 담긴 문자열 배열
     * @return  로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표]
     */
    
    public static int[] walk_park(String[] park, String[] routes) {
        int H = park.length; //공원 높이
        int W = park[0].length(); //공원 넓이

        //시작지점 찾기
        int x = 0;
        int y = 0;

        for(int i=0;i<park.length;i++){
            if(park[i].indexOf('S') != -1){
                x = park[i].indexOf('S');
                y = i;
                break;
            }
        }


        //산책
        for(String route: routes){
            String[] command  = route.split(" ");
            //방향 과 이동 거리로 나눔. 
            char direction = command[0].charAt(0); //방향
            int distance = Integer.parseInt(command[1]); //거리

            System.out.println(direction+distance);

            int currX = x;
            int currY = y;

            // 방향에 따른 이동 처리
            if (direction == 'N') { //북
                boolean flag = true;
                //범위를 벗어났나 체크
                for(int j=0;j<distance;j++){

                    currY--;

                    if(currY < 0){	//범위를 벗어났나
                        flag = false;
                        break;
                    } // 장애물이 있나
                    else if(park[y].charAt(x) == 'X'){
                        flag = false;
                        break;
                    }

                    if (flag) {
                        y = currY;
                    }
                }
            } else if (direction == 'S') { //남
                 boolean flag = true;
                 for(int j=1;j<=distance;j++){

                    currY++;

                    if(currY > H){	//범위를 벗어났나
                        flag = false;
                        break;
                    } // 장애물이 있나
                    else if(park[y].charAt(x) =='X'){
                        flag = false;
                        break;
                    }

                    if (flag) {
                        y = currY;
                    }
                }
    
            } else if (direction == 'W') { //서
                  boolean flag = true;
                 for(int j=1;j<=distance;j++){

                    currX--;

                    if(currX < 0){	//범위를 벗어났나
                        flag = false;
                        break;
                    } // 장애물이 있나
                    else if(park[y].charAt(x) =='X'){
                        flag = false;
                        break;
                    }

                    if (flag) {
                        x = currX;
                    }
                }
            } else if (direction == 'E') { //동
                 boolean flag = true;
                 for(int j=1;j<=distance;j++){

                    currX++;

                    if(currX > W){	//범위를 벗어났나
                        flag = false;
                        break;
                    } // 장애물이 있나
                    else if(park[y].charAt(x) =='X'){
                        flag = false;
                        break;
                    }

                    if (flag) {
                        x = currX;
                    }
                }
            }
            
       

        }   
        
        
        int[] answer = {y,x};
        return answer;
    }

    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        
        int[] answer = walk_park(park,routes);
        System.out.println(Arrays.toString(answer));
    }

}
