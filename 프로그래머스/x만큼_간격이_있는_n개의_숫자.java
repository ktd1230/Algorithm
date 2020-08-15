package 프로그래머스;

import java.util.Arrays;

public class x만큼_간격이_있는_n개의_숫자 {
	
	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		System.out.println(Arrays.toString(solution(x, n)));
	}
	
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		for(int i = 0; i < n; i++) {
			answer[i] = (long)(i + 1) * x;
		}
		
		return answer;
	}

}
