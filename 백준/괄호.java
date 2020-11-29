package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			String ans = "YES";
			for(int i = 0; i < s.length(); i++) {
				if(stack.isEmpty() || s.charAt(i) == '(')
					stack.push(s.charAt(i));
				else if(s.charAt(i) == ')') {
					if(stack.peek() == '(')
						stack.pop();
					else {
						ans = "NO";
						break;
					}
				}
			}
			if(!stack.isEmpty())
				ans = "NO";
			System.out.println(ans);
		}
	}

}
