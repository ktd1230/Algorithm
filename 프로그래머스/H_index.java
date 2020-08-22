package 프로그래머스;

import java.util.Arrays;

public class H_index {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		for (int i = citations.length - 1; i >= 0; i--) {
			if(citations[i] <= citations.length - 1 - i) {
				answer = citations[i];
                break;
            }
		}
		return answer;
	}
	
}
