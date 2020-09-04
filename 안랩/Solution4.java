package 안랩;

public class Solution4 {
	public static void main(String[] args) {
		int[][] position = { { 1, 1 }, { -1, 1 }, { -1, -1 }, { 0, 0 } };
		System.out.println(solution(position));

	}

	public static long solution(int[][] positions) {
		long answer = 0;
		int max_x = -987654321;
		int max_y = -987654321;
		int min_x = 987654321;
		int min_y = 987654321;
		for (int i = 0; i < positions.length; i++) {
			max_x = Math.max(positions[i][0], max_x);
			max_y = Math.max(positions[i][1], max_y);
			min_x = Math.min(positions[i][0], min_x);
			min_y = Math.min(positions[i][1], min_y);
		}
		long min_len = Long.MAX_VALUE;
		for (int i = min_x; i <= max_x; i++) {
			for (int j = min_y; j <= max_y; j++) {
				int len = 0;
				for (int p = 0; p < positions.length; p++) {
					len += Math.abs(i - positions[p][0]) + Math.abs(j - positions[p][1]);
				}
				if (len < min_len) {
					answer = 1;
					min_len = len;
				} else if (len == min_len) {
					answer++;
				}
			}
		}
		return answer;
	}
}