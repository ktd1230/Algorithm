package 프로그래머스;

import java.util.*;

public class 영어_끝말잇기 {

	public static void main(String[] args) {
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		System.out.println(Arrays.toString(solution(n, words)));
	}
	
	public static int[] solution(int n, String[] words) {
		int[] answer = {0, 0};
		int[] cnt = new int[n];
		HashMap<String, Boolean> map = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			if(map.get(words[i]) != null || (i != 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) {
				answer[0] = i % n + 1;
				answer[1] = cnt[i % n] + 1;
				break;
			}
			cnt[i % n]++;
			map.put(words[i], true);
		}
		
		return answer;
	}
	
}
