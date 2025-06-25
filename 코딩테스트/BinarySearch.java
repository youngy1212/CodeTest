public class BinarySearch {
    
    //이진탐색 
    public static void main(String[] args) {
        
    }

    //부품 찾기 
    //문의 받은 부품 M개 종류를 확인 
    //입력 : 정수 M (<1,000,000) 정수 M (< 1,000,000)
    //로직 : 이진탐색 알고리즘으로 N개의 부품을 번호 기준으로 정렬, 
    //출력 : 존재하면 yes, 아니면 no

    //이진 탐색 코드(반복문)
    static int 부품찾기(int arr[], int target, int start, int end){

        while (start <= end) {
            int mid = (start+end)/2;

            if(arr[mid] == target) return mid; 
            else if(arr[mid] > target) end = mid -1;
            else start = mid +2;
        }
        return -1;
    }

    //떡볶이 떡 만들기
    //높이(H)보다 긴 떡만 잘린다. 요청한 총 길이를 얻기위해 H를 설정
    //입력 : 떡의 개수 N(1,000,000 이하) , 떡의 길이 M (2,000,000,000 이하)
    //로직 : 파라메트리 서치 : 원하는 높이를 찾을때까지 조정
        //'이 높으로 자르면 만족할 수 있나' 에서 예, 아니오로 탐색 범위로 저정
        // 절반씩 탐색 범위를 좁여나간다.
        // 10억까지의 정수중 하나면, 큰 수는 당연히 이진탐색을 고려해야한다.
        // 
    //출력 : H의 최대값 
    static int 떡자르기(int n, int m, int[] arr){


        //이진탐색 
        int start = 0;
        int end = (int) 1e9;

        int reuslt = 0;
        while (start <= end) {
            long total  = 0;
            int mid = (start + end)/2;
            for(int i = 0; i< n; i++){
                // 떡의양 계산
                if(arr[i] > mid) total += arr[i] - mid;
            }
            if(total < m){
                end = mid-1; //더 많이 자르기
            }else{
                reuslt = mid; //정답 또는 덜자르기 
                start = mid +1; 
            }

        }

        System.out.println(reuslt);

    }


}
