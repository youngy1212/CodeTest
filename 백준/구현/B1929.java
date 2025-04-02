import java.util.*;


public class B1929 {

     public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.close();


        for(int i = M; i <= N; i++){
            if(isPrime(i)){   
            System.out.println(i);
            }
        }
           
        

    }

    private static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i ==0) return false;
        }

        return true;
    }


}