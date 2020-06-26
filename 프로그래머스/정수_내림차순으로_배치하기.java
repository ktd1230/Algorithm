package 프로그래머스;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {

	public static void main(String[] args) {
		long n = 1474437020;
		System.out.println(solution(n));
	}
	
	public static long solution(long n) {
		long answer = 0;
		String tmp = "" + n;
		int[] arr = new int[tmp.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = tmp.charAt(i) - '0';
		}
		Arrays.sort(arr);
		long p = 1;
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i] * p;
			p *= 10;
		}
		return answer;
	}
	
}
