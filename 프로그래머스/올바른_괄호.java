package 프로그래머스;

import java.util.Stack;

public class 올바른_괄호 {

	public static void main(String[] args) {
		String s = "(()(";
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
		boolean answer = true;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(')
				cnt++;
			else if(cnt > 0 && s.charAt(i) == ')')
				cnt--;
			else {
				answer = false;
				break;
			}
		}
		if(cnt != 0)
			answer = false;
		return answer;
	}
}
