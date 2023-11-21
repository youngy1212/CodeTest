import java.util.Scanner;

public class B9095 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        for(int i = 0; i<t; i++){
            int n  = sc.nextInt();

            // dp[i]: 정수 i를 1, 2, 3의 합으로 나타내는 방법의 수
            int[] dp = new int[n + 1];

             // bottom-up 방식의 다이나믹 프로그래밍
             dp[1] = 1;
             if (n >= 2) dp[2] = 2; //최소값
             if (n >= 3) dp[3] = 4; //최소값
 
             for (int j = 4; j <= n; j++) {
                 dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
             }
 
             System.out.println(dp[n]);


        }
    }
    
}
