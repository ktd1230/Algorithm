package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크게_만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int k = K;
		String num = br.readLine();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			char c = num.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		StringBuilder ans = new StringBuilder();
		while(!stack.isEmpty()) {
			ans.append(stack.pop());
		}
		System.out.println(ans.reverse().substring(0, N - K).toString());
	}

}
