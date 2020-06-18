package 프로그래머스;

import java.util.Arrays;

public class 문자열_내림차순으로_배치하기 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		String answer = "";
		char[] c = s.toCharArray();
		Arrays.sort(c);
		for (int i = c.length - 1; i >= 0; i--) {
			answer += c[i];
		}
		return answer;
	}
}
