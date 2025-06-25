import java.util.Arrays;

public class Dynamic {
    

    //다이나믹 프로그래밍
    public static void main(String[] args) {
        
    }

    //1로 만들기 
    //정수가 주어졌을 때 연산 4개를 적절히 사용해서 1을 만들려한다. 
    //입력 : 정수  X (<30,000) 
    //로직 : 보텀업 방법을 사용해서 계산 
    //출력 : 연산에 사용하는 횟수의 최솟값 
    static void 일로만들기(int x){


        //계산결과를 저장하기 위한 DP 테이블
        int[] d = new int[30001];


        for(int i = 2; i <= x; i++){
            //현재수에서 1을 빼는 경우
            d[i] = d[i-1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }
        System.out.println(d[x]);
    }

    //개미 전사 
    //일직선상에 존재하는 창고에 서로 인접한 식량이 공격받으면 알아챌수있다.
    //입력 : 식량창고 개수 (3<N<100), 각 창고의 식량의 개수 K
    //로직 : 왼쪽부터 차례로 더 많이 털 수 있는걸 선택 보텀업
    //출력 : 얻을 수 있는 식량의 최대값 
    static void 개미전사(int n, int[] arr){


        //계산결과를 저장하기 위한 DP 테이블
        int[] d = new int[100];

        d[0] = arr[0];
        d[1] = Math.min(arr[0], arr[1]);
        for(int i =2; i < n; i++){
            d[i] = Math.max(d[i-1], d[i-2]+ arr[i]);
            //앞과 그전 앞 값을 비교해서 큰값 넣기
        }

        System.out.println(d[n-1]);    
    }

    //효율적인 화페구성 
    // N가지 종류의 화페가 있다. 최소한으로 이용해서 그 가치의 합이 M 이 되도록해라
    //입력 : N (1 <100) M (< 10,000) 이후 화페 가치가 주어지는 10,000보다 작거나 같다 
    //로직 : 적은수부터 큰 금액까지 차례로 확인하여 만들 수 있는 최소 화폐 개수를 찾기 
    //
    //출력 : 화폐 최소 개수 출력 
    static void 화페구성(int n,int m, int[] arr){


        //계산결과를 저장하기 위한 DP 테이블
        int[] d = new int[m+1];
        Arrays.fill(d, 10001); //10000이상은 없음 

        //보텀업 방식
        d[0] = 0;
        for(int i = 0; i <n; i++){
            for(int j = arr[i]; j<=m; j++){
                //만드는 방법이 존재하는 경우
                if(d[j] - arr[j] != 10001){
                    d[j] = Math.min(d[j], d[j - arr[i]]+1);
                }
            }
        }   
        if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }  
    }



}
