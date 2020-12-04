package 백준;

import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class 탑 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[arr.length];
		answer[arr.length - 1] = -1;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		stack.push(arr[0]);
		index.push(0);
		for (int i = 1; i < arr.length ; i++) {
			while (!stack.isEmpty()) {
				if (arr[i] < stack.peek()) {
					answer[i] = index.peek() + 1;
					break;
				}
				stack.pop();
				index.pop();
			}
			if(stack.isEmpty())
				answer[i] = 0;
			stack.push(arr[i]);
			index.push(i);
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
