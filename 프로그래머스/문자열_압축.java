package 프로그래머스;
import java.util.*;

public class 문자열_압축 {
	
	public static void main(String[] args) {
		String s1 = "aabbaccc";
		String s2 = "ababcdcdababcdcd";
		String s3 = "abcabcdede";
		String s4 = "abcabcabcabcdededededede";
		String s5 = "xababcdcdababcdcd";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
		System.out.println(solution(s5));
	}
	
	public static int solution(String s) {
		int answer = Integer.MAX_VALUE;
				
		for (int i = 0; i < s.length(); i++) {
			Stack<String> stack1 = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			String tmp = "";
			for (int j = 0; j < s.length(); j++) {
				tmp += s.charAt(j);
				if((j + 1) % (i + 1) == 0) {
					if(stack1.isEmpty()) {
						stack1.push(tmp);
						stack2.push(1);
					} else if(stack1.peek().equals(tmp)){
						stack2.push(stack2.pop() + 1);
					} else {
						stack1.push(tmp);
						stack2.push(1);
					}
					tmp = "";
				}
			}
			if(!tmp.equals("")) {
				if(stack1.peek().equals(tmp)){
					stack2.push(stack2.pop() + 1);
				} else {
					stack1.push(tmp);
					stack2.push(1);
				}
			}
			int count = 0;
			String res = "";
			while(!stack1.isEmpty()) {
				int num = stack2.pop();
				if(num != 1)
					res += num;
				res += stack1.pop();
			}
			
			count += res.length();
			answer = Math.min(answer, count);
		}

		return answer;
	}
}
