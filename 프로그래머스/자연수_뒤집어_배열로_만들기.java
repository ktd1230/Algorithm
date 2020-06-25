package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {

	public static void main(String[] args) {
		long n = 12345;
		System.out.println(Arrays.toString(solution(n)));
	}
	public static int[] solution(long n) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		while(n > 0) {
			list.add((int) (n % 10));
			n /= 10;
		}
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
