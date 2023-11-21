
import java.util.Scanner;

public class B1463 {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // dp[i]: 정수 i를 1로 만들기 위한 최소 연산 횟수
        int[] dp = new int[n + 1];
        
        // bottom-up 방식의 다이나믹 프로그래밍
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  // 1을 빼는 경우

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);  // 2로 나누는 경우
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);  // 3으로 나누는 경우
            }
        }

        System.out.println(dp[n]);

    }

}

