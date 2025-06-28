import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath {

    public static void main(String[] args) {
        
    }

    // 미래도시 연결
    // K번 회사를 거쳐 X번 회사로 가는 최소 이동시간
    // 입력 : 회사의 개수 N, 경로의 개수 M(<=100)
    // 로직 : 플로이드 위셜 알고리즘 문제 
    // 범위가 100이하로 매우 한정적인 경우 구현이 간단한 플로이드 워셜로 푸는게 유리 
    // 출력 : 정렬된 결과를 출력 
    static void 미래도시(int n, int m ){

        Scanner sc = new Scanner(System.in);

        //2차월 배열 그래프 표현 만들기
        int[][] graph = new int[101][101]; 


        //최단거리 테이블을 무한으로 초기화
        for(int i = 0; i<101; i++){
            Arrays.fill(graph[i], (int) 1e9);
        }

        //자신에게 가는 비용은 0임
        for(int a = 1; a<=n; a++){
            for(int b =1; b<=n; b++){
                if(a == b) graph[a][b] = 0;
            }
        }

        //간선의 값을 초기화
        for(int i = 0; i <m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1; 
            graph[b][a] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();

        //점화식에 따라 플로이드 워셜 알고리즘 
        for (int k1 = 1; k1 <= n; k1++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k1] + graph[k1][b]);
                }
                //직접가는 경우와 k1을 경유해서 가는 경우와 비교하여 더 짧은 족으로 갱신 
            }
        }

        int distance = graph[1][k] + graph[k][x];

        // 도달할 수 없는 경우, -1을 출력
        if (distance >= (int) 1e9) {
            System.out.println(-1);
        }
        // 도달할 수 있다면, 최단 거리를 출력
        else {
            System.out.println(distance);
        }
    }

    
    // 전보
    // C라는 도시에서 메시지를 보냈을 때 받게되는 도시의 개수와, 걸리는 시간을 계산
    // 입력 : 도시의 개수 N(< 30,000) 통로의 개수 M(<200,000), 도시 C 
    // 둘째 줄 부터 통로에 대한 정보 X(특정 도시) , Y (이어지는 도시) ,Z (메세지 전달시간) 
    // 로직 : '최단거리' 문제이므로 다익스트라 알고리즘을 이용 
    // 또한 N, M 의 범위가 크기때문에 우선순위 큐를 이용하여 알고리즘 작성 
    // 범위가 100이하로 매우 한정적인 경우 구현이 간단한 플로이드 워셜로 푸는게 유리 
    // 출력 : 도시의 총 개수 총 걸리는 시간 

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[30001]; //최단거리 테이블 

    static void 전보(int n, int m , int start){

         Scanner sc = new Scanner(System.in);

        for(int i = 0; i<=n; i++){ //그래프 초기화
            graph.add(new ArrayList<Node>());
        }
       
        for(int i = 0; i <m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph.get(x).add(new Node(y, z));
        }

        Arrays.fill(d, (int)1e9);

        dijkstra(start);

        int count = 0; // 도시 개수
        int maxDistance = 0;  //마지막 도시의 시간 
        for(int i = 1; i <=n; i++){

            if(d[i] != (int)1e9){
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println((count -1)+ " "+maxDistance);


    }
    static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 우선순위 큐

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            
            Node node = pq.poll();
            int dist = node.getDistance(); //현재 노드까지 비용
            int now = node.getIndex(); //현재 노드

            if(d[now] < dist) continue; //처리완료된 노드 확인

            for(int i = 0; i <graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]){
                    //현재노드를 거쳐서 다른노드로 이동하는 거리가 더 짧음
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }

        }

    }

}



class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

