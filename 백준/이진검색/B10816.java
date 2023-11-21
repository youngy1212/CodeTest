import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10816 {

    //이진검색으로 하려고 했으나, 중복값을 체크해야해 hashMap으로 해결하기로 함

    public static void main(String[] args) throws IOException{
        //숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 
        //상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
        //상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)
        //둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
        //셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어진다

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringBuffer sb = new StringBuffer(); //정답

        //숫자카드를 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());

            //처음들어오는 숫자라면 
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }

        //찾을 카드 입력
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());

            //숫자가 존재?
            if(map.containsKey(num)){
                sb.append(map.get(num)+" ");
            }
            //없다면
            else{
                sb.append(0+" ");
            }
        }

        System.out.println(sb.toString());


    }

}