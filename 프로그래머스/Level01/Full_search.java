public class Full_search {

    /**
     * 지갑의 크기를 정하려고 합니다. 
     * 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 
     * @param sizes 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수
     * @return 모든 명함을 수납할 수 있는 가장 작은 지갑
     */
    public static int full_search(int[][] sizes) {

        //완전탐색 사용 
        int preMax = 0;
        int preMin = 0;

        for(int[] size : sizes){ //길이 높이 비교가 아니라, 큰 쪽, 작은 쪾으로 비교!
            int curMax = Math.max(size[0], size[1]); //큰쪽
            int curMin = Math.min(size[0], size[1]); //작은쪽

            preMax = Math.max(preMax, curMax);
            preMin = Math.max(preMin, curMin);
        }

        return preMax*preMin;
    }

    public static void main(String[] args) {
        int[][] sizes = {{0, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(full_search(sizes));
    }
    
}
