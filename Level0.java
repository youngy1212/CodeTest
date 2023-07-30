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
    }



}
