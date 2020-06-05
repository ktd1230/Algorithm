package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class K번째수 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println(Arrays.toString(solution(array, commands)));
	}
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		ArrayList<Integer> result = new ArrayList<>(), temp = new ArrayList<>();
		for (int[] i : commands) {
			for (int j = i[0] - 1; j <= i[1] - 1; j++) {
				temp.add(array[j]);
			}
			Collections.sort(temp);
			result.add(temp.get(i[2] - 1));
			temp.clear();
		}
		answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}
}
