import java.util.*;
import java.io.*;

public class B16401 {
    
    //https://www.acmicpc.net/problem/16401 

    //입력 : 조카의 수 M, 과자의수 N (최대 백개) 
    // 과자 N 개의 길이 공백으로 구분되어 주어짐

    //로직 : 100개 이상이 될수있으니, 완탐은 제외
    // 나눠줄수있는 인원, 몫으로 구함.
    // 과자를 나누는 값을 기준으로 이분탐색 진행
    // 개수가 많다면 나눠줄 길이를 늘리고 개수가 적다면 나눠줄 길이를 줄인다. 


    //출력 : 조카 1명에가 줄 수 있는 막대과자 최대길이
    // 모든 조카에게 같은 길이를 나눠줄수없다면 0을 출력

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snacks = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);

        int result = 0;
        int maxSize = snacks[N-1];
        int count = 0;

        for(int s : snacks){
            count += s / maxSize;
        }

        if(count >= M ){
            System.out.println(maxSize);
            return;
        }

        int left = 1;
        int right = maxSize;

        while (left <= right) {
            
            int mid = (left + right) /2;
            count = 0;
			for(int s : snacks) {
				count += s / mid; //현재 길이로 몇 명에게 줄 수 있는지 센다.
			}
			
			if(count >= M) {
				result = Math.max(mid, result);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
        }

        System.out.print(result);
    }


}
