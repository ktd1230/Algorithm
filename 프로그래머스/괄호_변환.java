package 프로그래머스;

import java.util.*;

public class 괄호_변환 {
	
	public static void main(String[] args) {
		String s = "()))((()";
		System.out.println(solution(s));
	}
	
	public static String solution(String p) {
		if(p.equals(""))
			return p;
		
		String answer = "";
		String u = ""; // 균형잡힌 괄호 문자열
		String v = ""; // 균형잡힌 괄호 문자열
		int cnt = 0;
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(')
				cnt++;
			else if(p.charAt(i) == ')')
				cnt--;
			u += p.charAt(i);
			if(cnt == 0) {
				v = p.substring(i + 1);
				break;
			}
		}
		boolean isURight = true;
		Stack<Character> uStack = new Stack<>();
		for(int i = 0; i < u.length(); i++) {
			char c = u.charAt(i);
			switch(c) {
			case '(' :
				uStack.push(c);
				break;
			case ')' :
				if(uStack.isEmpty()) {
					isURight = false;
					break;
				}
				uStack.pop();
				break;
			}
		}
		if(isURight) {
			answer = u + solution(v);
		} else {
			answer = "(";
			answer += solution(v);
			answer += ")";
			u = u.substring(1, u.length() - 1);
			for(int i = 0; i < u.length(); i++) {
				answer += u.charAt(i) == '(' ? ')' : '(';
			}
		}
		return answer;
	}

}
