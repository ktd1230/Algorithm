package 프로그래머스;

public class 땅따먹기 {
	
	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));
	}
	
	public static int solution(int[][] land) {
		int answer = 0;
        int forward_idx = -1;
        for(int i = 0; i < land.length; i++){
            int max = 0;
            int idx = -1;
            for(int j = 0; j < 4; j++){
                if(j != forward_idx && land[i][j] > max){
                    idx = j;
                    max = land[i][j];
                }
            }
            forward_idx = idx;
            answer += max;
        }

        return answer;
	}

}
