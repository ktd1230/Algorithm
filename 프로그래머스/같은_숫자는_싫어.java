package 프로그래머스;

import java.util.Arrays;
import java.util.Stack;

public class 같은_숫자는_싫어 {

	public static void main(String[] args) {
		int[] arr = {4,4,4,3,3};
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	public static int[] solution(int[] arr) {
		int[] answer = {};
		Stack<Integer> stack = new Stack<>();
		for (Integer i : arr) {
			if(stack.isEmpty() || !stack.isEmpty() && stack.peek() != i) {
				stack.push(i);
			}
		}
		int idx = stack.size();
		answer = new int[idx];
		while(!stack.isEmpty()) {
			answer[--idx] = stack.pop();
		}
		return answer;
	}
}
