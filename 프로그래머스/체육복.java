package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;

public class 체육복 {

	public static void main(String[] args) {
		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
		System.out.println(solution(n, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < lost.length; i++) {
			list.add(lost[i]);
		}
		Collections.sort(list);
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if(reserve[i] == list.get(j)) {
					list.remove(j);
					reserve[i] = -1;
					break;
				}
			}
		}
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if(reserve[i] != -1 && (reserve[i] - 1 == list.get(j) || reserve[i] + 1 == list.get(j))) {
					list.remove(j);
					break;
				}
			}
		}
		answer = n - list.size();
		return answer;
	}
}
