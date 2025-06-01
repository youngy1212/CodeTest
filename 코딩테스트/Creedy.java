import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Creedy {
    
    //가장 좋은 것만 고르는 해법

    public static void main(String[] args) {
        //거스름돈
        int n = 1260;
        int count = 0;

        거스름돈(n, count);

    }

    static void 거스름돈(int n, int count) {

        int[] coin_type = {500, 100, 50, 10};
        
        for(int i =0; i<4; i++){
            int coin = coin_type[i];
            count += n/coin;
            n %= coin;
        }
        System.out.println(count);
    
    }

    //큰수의 법칙 
    // 주어진 수를 M 번 더하여 가장 큰수를 만들기 연속으로 K번까지만 가능하다. 
    //입력 : 배열의 크기 N , M, K 의 자연수가 주어진다.  K는 항상 M보다 작거나 같다. 
    //로직 : 가장큰수와, 두번째로 큰수 가장 큰수를 K번 더하고 두번째수를 더하고, 다시 큰수를 더한다. 
    //출력 : 큰수의 법칙으로 구해진 가장 큰 값 


    static void 큰수의법칙칙() {

        Scanner sc = new Scanner(System.in);

        //입력
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); //정렬함수
        int B1 = arr[n-1];
        int B2 = arr[n-2];

        int count = (m / (k+1)) * k; // K+1 나눠보기  K의 숫자
        count += m%(k+1);  // 나머지값 

        int result = 0;
        result += count * B1;
        result += (m- count) * B2; 

        System.out.println(result);
    }


    //숫자카드게임 
    //행을 먼저 선택한다. 행 중에 가장 숫자가 낮은 카드를 뽑아야한다. 그후 열에서 가장 큰수를 찾는다.
    //입력 : 첫째줄에 행 N 열 M 이후 N줄에 걸쳐 카드에 적힌 숫자가 주어진다. 
    //로직 : 각 행마다 가장 작은 수를 찾을 뒤, 그 수 중에서 가장 큰수를 찾는 것 Math 함수사용용
    //출력 : 찾은 수 출력 

    static void 숫자카드게임(){

        //입력
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        //로직
        for(int i =0; i<n; i++){

            //작은수 찾기
            int minValue = 100001;
            for(int j = 0; j<m; j++){
                int x = sc.nextInt();
                minValue = Math.min(minValue, x);
            }

            //해당 열에서 가장 큰 수 찾기
            result = Math.max(result, minValue);
        }

        System.out.println(result);
    }



    //1이 될때까지지 
    //입력 : 첫재쭐에 N(100,000이하) , K(100,000이하) 가 각각 주어진다 
    //로직 : 최대한 많이 나누기를 사용한다. 
    //출력 : 1,2번을 수행하는 횟수의 최솟값
    static void 일이될때까지() {

        Scanner sc = new Scanner(System.in);

        //입력
        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = 0;

        //로직
        while (n >= k) {
            //안나눠지면 -1
            while (n % k != 0) {
                n -= 1;
                result++;
            }

            // k 로 나누기
            n= n/k;
            result++;
        }

        result += (n-1); //남은 수 빼기기
        System.out.println(result);
    }

  

}
