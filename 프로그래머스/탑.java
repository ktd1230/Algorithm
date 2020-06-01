package 프로그래머스;

import java.util.Arrays;

public class 탑 {

	public static void main(String[] args) {
		int[] heights1 = {6,9,5,7,4};
		int[] heights2 = {3,9,9,3,5,7,2};
		int[] heights3 = {1,5,3,6,7,6,5};
		System.out.println(Arrays.toString(solution(heights1)));
	}
	
	public static int[] solution(int[] heights) {
		int len = heights.length;
		int[] answer = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}
		return answer;
	}
}
