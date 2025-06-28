import java.util.*;

public class Graph {

    public static void main(String[] args) {
        
    }

    // 팀결성 
    // 팀 합치기, 같은 팀 여부 확이 연산 사용 
    // 입력 : 학생 번호 N , M 연산의 개수 (<=100,000)
    // 0 a b (팀 합치기)
    // 1 a b (같은팀 확인 )
    // 로직 : 서로소 집합 
    // 출력 : 같은 팀확인에 YES, NO 출력 

    public static int[] parent = new int[100001]; //팀 확인

    static void 같은팀(int n, int m ){
       Scanner sc = new Scanner(System.in);
       //초기화
       for(int i = 1; i <=n; i++){
        parent[i] = i;
       }
       
       //각 연산 확인 
       for(int i = 0; i <m; i++){
        int operation = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(operation == 0){
            unionParent(a, b);
        }

        if(operation == 1){
            if(findParent(a)== findParent(b)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
       }

    }

    //팀 찾기
    public static int findParent(int x){
        
        if( x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
        //루트노드까지 
    }

    //팀 합치기
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    // 도시 분할 계획 
    // 마을 N 개의 집, M개의 길, 2개로 분할 후 
    // 1.두 마을 사이의 길을 없앨 수 있음
    // 2. 분리된 마을안에 경로가 존재하면 길을 더 없앨 수 있음 
    // 입력 : 집의 개수 (< 100,000), 길의 개수 M (< 1,000,000)
    // M줄에 걸처 A B C (a와 b의 길의 유지비) 
    // 로직 : 2개의 신장트리를 만들어야함. 
    // 크루스칼 알고리즘으로 최소 신장트리를 찾을 뒤 취소 신장트리를 구성하는 간선 중
    // 비용이 큰 간선을 제거,
    // 출력 : 첫쨰 줄에 길을 없애고 남은 유지의 합의 최솟값 
    static void 도시분할(int n, int m){
        Scanner sc = new Scanner(System.in);

        for(int i =1; i <= n; i++){
            parent[i] = i;
        }//초기화

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            //비용순으로 정렬하기 위해 첫번째 요소를 비용으로 설정
            edges.add(new Edge(cost, a, b));
        }

        Collections.sort(edges);
        int last  = 0; //가장 비용이 큰 간선 
        int result = 0;

        for(int i = 0; i<edges.size(); i++){
            int cost  = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            //사이클이 발생하지 않는 경우에만 집합에 포함
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }

        //마지막으로 추가한 간선이 가장 크기가 크니 해당을 끊어서 마을 2개를 생성
        System.out.println(result - last);
    
    }


    public static int[] parents = new int[100001]; 

    // 모든 간선을 담을 리스트
    public static ArrayList<Edge> edges = new ArrayList<>(); 


    // 커리큘럼 
    // 어떤 강의는 이전에 들어야하는 강의가 있다. 
    // 입력 : 강의의 수 N(1<N<500), 강의 강의시간 (100,000), 먼저들어야하는 번호 
    // 각 강의 번호는 1~N까지이며 각줄은 -1로 끝남  
    // 로직 : 위상정렬 알고리즘 큐를 통해 순차적으로 처리
    // 출력 : N개의 강의에 대해서 수강하기까지 걸리는 최소시간 
    static void 커리큘럼(int n){

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i =1; i <= n; i++){
            int x = sc.nextInt();
            times[i] = x;

            while (true) {
                x = sc.nextInt();
                if(x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i);   
            }
        }

        topologySort(n);
    
    }

     // 모든 노드에 대한 진입차수는 0으로 초기화
    public static int[] indegree = new int[501];

    public static int[] times = new int[501]; //각 강의시간 

     public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
     //연결 리스트

    //위상정렬 
    public static void topologySort(int v){
        int[] result = new int[501]; //결과 배열

        //노드의 개수만큼 초기화
        for(int i =1; i<=v; i++){
            result[i] = times[i]; //강의시간
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =1; i<=v; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int now = q.poll();//큐에서 꺼내기
            for(int i =0; i< graph.get(now).size(); i++){
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now]+times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }   
        }

        for(int i =1; i <=v; i++){
            System.out.println(result[i]);
        }
    }


}



    class Edge implements Comparable<Edge> {

        private int distance;
        private int nodeA;
        private int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return this.distance;
        }

        public int getNodeA() {
            return this.nodeA;
        }

        public int getNodeB() {
            return this.nodeB;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Edge other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }

