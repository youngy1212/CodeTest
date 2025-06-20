import java.util.*;

public class sort {
    

    public static void main(String[] args) {
        
    }


    // 위에서 아래로 
    // 큰수부터 작은수로 정렬 
    // 입력 수의 개수가 N 이후 입력 범위는 1~ 100,000 
    // 로직 : Sort로 정렬 
    // 출력 : 정렬된 결과를 출력 
    static void 위아래(int n, Integer[] arr ){

        //정렬 라이브러리 사용 
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    // 성적이 낮은 순서로로
    // 작은수부터 정렬
    // 학생 수 < 100,000 성적은 100이하의 자연수
    // 로직 : 학생 수는 많은데 성적수는 100이니 밀집된 데이터로 계수 정렬렬
    // 출력 : 정렬된 결과를 출력 
    static void 낮은순서로(int n, List<Student> students){

        Collections.sort(students);

        for(int i =0; i< students.size(); i++){
            System.out.print(students.get(i).getName() + " ");
        }
    }

    //배열의 원소교체
    //A,B 의 배열을 K 만큼 교체
    //입력 : N 배열의 크기(100,000) K 교체숫자 (N보다 작음) 
    //로직 : A는 오른차순으로 정렬하고, B는 내림차순으로 정렬하여 A원소가 B원소보다 작으면 교체
    // 100,000 까지 입력 될 수 있으므로 NlogN 의 의 정렬을 해야함 
    //출력 : A의 원소의 합이 최댓값 출력
    static void 원소교체(int n, int K, Integer[] a, Integer[] b){

        Arrays.sort(a); //오름차순
        Arrays.sort(b, Collections.reverseOrder()); //내림차순

        for(int i = 0; i < k; i++){
            
            if(a[i] < b[i]){
                int tmep = a[i];
                a[i] = b[i];
                b[i] tmep;
            }
            else break; 
        }

        long result = 0;
        for( int i = 0; i < n; i++){
            result += a[i];
        }

        System.out.println(result);

    }
    

}

class Student implements Comparable<Student> {
    // 객체 정렬

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // 정렬 기준은 점수가 낮은 순서
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}
