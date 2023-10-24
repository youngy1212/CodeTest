
import java.util.Arrays;

public class Paint_over {

    /**
     * 
     * 롤러로 벽에 페인트를 한 번 칠하는 규칙은 다음과 같습니다.
     * 1. 롤러가 벽에서 벗어나면 안 됩니다.
     * 2. 구역의 일부분만 포함되도록 칠하면 안 됩니다.
     * -> 현재 페인트를 칠하는 구역들을 완전히 칠한 후 벽에서 롤러를 떼며, 이를 벽을 한 번 칠했다고 정의.
     * 3. 한 구역에 페인트를 여러 번 칠해도 되고 다시 칠해야 할 구역이 아닌 곳에 페인트를 칠해도 되지만 
     * 다시 칠하기로 정한 구역은 적어도 한 번 페인트칠을 해야 합니다.
     * 4. 롤러로 페인트칠을 하는 횟수를 최소화
     * 
     * @param n  벽을 1미터 길이의 구역 n개로 나누고, 각 구역에 왼쪽부터 순서대로 1번부터 n번까지 번호를 붙였습니다
     * @param m 벽에 페인트를 칠하는 롤러의 길이는 m미터
     * @param section 다시 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열
     * @return  롤러로 페인트칠해야 하는 최소 횟수를 return
     */

    public static int paint_over(int n, int m, int[] section) {
        /* 그리디 알고리즘 
         * 처음 벽 번호 + 롤러 크기만큼 에 해당하는 벽은 한번 칠한 걸로 하고 계속 반복
         */

         //무조건 start 한번은 칠해지니까 1로 시작. 
        int answer = 1;

        int start = section[0];

        for(int item : section){
            if(start + m - 1 < item){
                answer++;
                start = item;
            }
           
        }


        return answer;
    }
    
      public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int section[] = {2,3,6};
        int answer = paint_over(n, m,section);
        System.out.println(answer);
    }

}
