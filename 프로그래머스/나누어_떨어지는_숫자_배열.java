package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {

	public static void main(String[] args) {
		int[] arr = {3,2,6};
		int divisor = 10;
		System.out.println(Arrays.toString(solution(arr, divisor)));
	}
	
	public static int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0)
				list.add(arr[i]);
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);
		if(list.size() == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}
}
