package 프로그래머스;

import java.util.StringTokenizer;

public class 최댓값과_최솟값 {
	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		String answer = "";
		StringTokenizer st = new StringTokenizer(s);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		answer = min + " " + max;
		return answer;
	}
}
