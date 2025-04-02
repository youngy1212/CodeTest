//프로그래머스 바탕화면 정리
// 시뮬레이션

//입력 : 컴퓨터 바탕화면 문자열 배열 . 이 빈칸 # 은 파일 있음


// 로직 : 처음부터 끝까지 시뮬레이션 하면서 #의 위치를 알아낸다. 
// 시작점과 끝점 후보를 갱신
// 드래그 영역은 격자점 기준으로 파일의 영억을 모두 포함하기 위해 +1 

//출력  : 드래그의 시작점, 끝점을 담은 정수 배열 
// 단, 드래그 후 직사각형 내부의 모든 파일을 포함해야함 

import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        //시작점 끝점
        int minRow, minCol;
        int maxRow, maxCol;
        
        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(wallpaper[i].charAt(j) == '#') {
                    
                    //파일이 있을 경우 갱신 
                    minRow = Math.min(minRow, i);  
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                    
                }
            }
            
        }
        
        return new int[]{minRow, minCol, maxRow+1, maxCol+1};
        
        
    }
}