import java.util.Scanner;

public class Level0 {
    
    /* 문자열 출력하기 */ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        System.out.print(a);
    }

    /*문자열 반복해서 출력하기 */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        for(int i=0; i<n; i++){
             System.out.print(str);
        }

        //System.out.println(str.repeat(n)); 이런 방법도 있음
       
    }

    /*대소문자 바꿔출력하기 출력하기 */
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder result = new StringBuilder();
        //toCharArray => 배열로 만들기
        for (char c : a.toCharArray()) {
            if (Character.isUpperCase(c)) {
                //isUpperCase 대문자일경우 Ture 아닌경우 false반환
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }

        System.out.println(result);

        /*
            !@#$%^&*(\'"<>?:; => 출력예시
             System.out.print("!@#$%^&*(\\\'\"<>?:;");
             \'" 앞에 \붙여주기
         */
       
    }

    /*짝수 홀수 구분하기 */
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n%2 == 0){
            System.out.print(n+" is even");
        }else{
            System.out.print(n+" is odd");
        }
   

    /* 문자열 섞기 */
    for(int i = 0; i < str1.length(); i++){
        answer+= str1.charAt(i);
        answer+= str2.charAt(i);
    }

    /*문자 리스트를 문자열로 변환하기 */
    for(int i=0; i < arr.length; i++ ){
        answer += arr[i];

        // return String.join("", arr); 도 사용가능 join함수
    }

    //문자열 곱하기 -> 문자열을 k만큼 반복
    //return my_string.repeat(k);

    }

    
    public int solution(int a, int b) {

        /*더 큰값을 합치기 */
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        String strSum1 = strA + strB;
        String strSum2 = strB + strA;
       
        Math.max(Integer.valueOf(strSum1), Integer.valueOf(strSum2));

        /*두 수의 연산값 비교하기  */
        /* max함수의 경우 두값이 같을 경우 앞의 값을 return함 */
        Math.max(Integer.parseInt(String.valueOf(a)+String.valueOf(b)),2*a*b);

       /*n의 배수일 경우*/
       int answer = 0;
        
       if(num%n == 0){
           answer = 1;
       }

       /* 공배수일 경우 */
       return number % n == 0 && number % m == 0 ? 1 : 0;

      

    }

     
     class Solution {
        public int solution61(String ineq, String eq, int n, int m) {

            /*홀짝에 따라 다른 값 반환 */
            for(int i = n; i >= 0; i -= 2)
            answer += (n % 2 == 0) ? i * i : i;
            
            /* 조건 문자열*/
            // if (ineq.equals("<") && eq.equals("=")) {
            // return n <= m ? 1 : 0;
            // }
        
            // if (ineq.equals("<")) {
            //     return n < m ? 1 : 0;
            // }
        
            // if (ineq.equals(">") && eq.equals("=")) {
            //     return n >= m ? 1 : 0;
            // }
        
            // if (ineq.equals(">")) {
            //     return n > m ? 1 : 0;
            // }    
        

             /*flag에 따라 다른 값 반환하기 */
             return flag ? a + b : a - b;
        }

        //등차수열의 특정한 항만 더하기
         public int solution62(int a, int d, boolean[] included) {
            int answer = 0;
                
            for(int i = 0; i<included.length; i++){
                if(included[i]){
                     answer += i*d+a;
                }
            }
            
            return answer;
        }

        //원소들의 합과 곱
        public int solution71(int[] num_list) {
            int answer = 0;
            
            int sum = 0;
            int mul = 1;
            
            for(int i = 0; i<num_list.length;i++){
                sum+=num_list[i];
                mul*=num_list[i];
            }
            if(sum * sum > mul){
                answer = 1;
            }
            
            return answer;
        }

        public int solution72(int[] num_list) {
            String a = "";
            String b = "";
            
            for (int i = 0; i < num_list.length ; i++) {
                if(num_list[i]%2 == 0){
                    b += num_list[i];
                }else{
                    a += num_list[i];
                }
            }
            return Integer.parseInt(a)+Integer.parseInt(b);
      
        }
    }
     
   

}
