import java.io.*;
import java.util.*;

public class B2559 {
    
    //입력 : N 전체 날짜의 수 , K 합을 구하기 위한 연속적 날짜 수 
    // 두번째 줄에 측정한 온도 

    //로직 : 투포인트로 N 포인트에서 , 두 값을 누적 앞에 한칸씩 이동하면서 end 값은 더하고 start 값은 뺸다.
    //그리고  최대 값과 비교한다. 

    //출력 : 연속적인 K일의 온도 최대값 출력

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        // 로직
        int sum = 0;
        

        for(int i = 1; i <= k; i++){
            sum += arr[i];
        }

        int max = sum;

        for(int i = k+1, j = 1; i < n; i++,j++){
            sum += arr[i] - arr[j];
            if(max < sum) max = sum;
        }

        System.out.println(max);

    }


}
