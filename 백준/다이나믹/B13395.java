import java.util.*;


public class B1929 {

    //피보나치수열일아 비슷한 ...
    //f(n) = f(n-1) + f(n-3)인 수열이다.
    // f(1) = f(2) = f(3) = 1

    //입력 : 자연수 n(1 ≤ n ≤ 116)

    //로직 : 메모이제이션을 해서 이미 계산한 값은 저장해두는 방식을 사용 
    // 배열에 정답을 저장한다. 저장된 결과를 이용해 해답을 구한다. 
    

    //출력 : n번째 피보나치 비스무리한 수를 출력

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
       
        long[] dp = new long[117];

        dp[1] = dp[2] = dp[3] = 1;
        for(int i = 4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-3]
        }

         System.out.print(dp[n]);
        

    }


}