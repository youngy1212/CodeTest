import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B1920 {

    //N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 
    //이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

    //첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
    //다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
    //모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());
            s.add(x);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <m; i++){
            if(s.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }
        
        System.out.println(sb);

    }

    //이외의 해결방법은
    //int[] arr = new int[n]; 배열에 넣고
    //Arrays.sort(arr);  //정렬후
    //binarySearch 이진검색트리 반복문으로 해결할 수 있다. 

    
   
}
