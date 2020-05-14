package 프로그래머스;

import java.util.Stack;

public class 쇠막대기 {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
	public static int solution(String arrangement) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		boolean check = false;
		boolean exist = false;
		for (int i = 0; i < arrangement.length(); i++) {
			char a = arrangement.charAt(i);
			if(a == '(') {
				stack.push(a);
				check = true;
				if(stack.size() >= 2)
					exist = true;
			}
			else if(check && a == ')'){
				answer += stack.size() - 1;
				stack.pop();
				check = false;
			}
			else if(!check && a == ')' && stack.size() >= 2) {
				answer++;
				stack.pop();
				check = false;
			}
			else 
				stack.pop();
			if(exist && stack.isEmpty()) {
				answer++;
				exist = false;
			}
		}
		return answer;
	}
}
