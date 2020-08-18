package 프로그래머스;

import java.util.*;

public class 짝지어_제거하기 {

	public static void main(String[] args) {
		String s = "cdcd";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(stack.isEmpty())
				stack.push(s.charAt(i));
			else if(stack.peek() == s.charAt(i))
				stack.pop();
			else
				stack.push(s.charAt(i));
		}
		if(stack.isEmpty())
			answer = 1;
		return answer;
	}
}
