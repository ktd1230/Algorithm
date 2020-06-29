package 프로그래머스;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	public static int[] solution(int[] arr) {
		int[] answer = {};
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
				idx = i;
			}
		}
		answer = new int[arr.length - 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if(i == idx)
				continue;
			answer[index++] = arr[i];
		}
		if(arr.length == 1) {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}
}
