package 프로그래머스;

import java.util.*;

public class 땅따먹기 {
	
	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));
	}
	
	public static int solution(int[][] land) {
		int answer = 0;
		int res1 = 0;
		int res2 = 0;
        int forward_idx = -1;
        int forward_idx2 = -1;
        for(int i = 0; i < land.length; i++){
            int max = 0;
            int max2 = 0;
            int idx = -1;
            for(int j = 0; j < 4; j++){
                if(j != forward_idx && land[i][j] > max){
                    idx = j;
                    max = land[i][j];
                }
                if(i > 0 && j != forward_idx2 && land[i][j] > max2){
                    idx = j;
                    max2 = land[i][j];
                }
            }
            if(i > 0)
            	forward_idx2 = idx;
            forward_idx = idx;
            res1 += max;
            res2 += max2;
        }
        
        Arrays.sort(land[0]);
        res2 += land[0][1];
        answer = Math.max(res1, res2);
        return answer;
	}

}
