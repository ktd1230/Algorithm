package 안랩;

import java.util.Arrays;

public class Solution1 {
	
	public static void main(String[] args) {
		String[] words = {"aeiou", "asdfgh", "yakkke", "abfedc", "xyzabc", "qwertyuiop"};
		System.out.println(Arrays.toString(solution(words)));
	}
	
	public static int[] solution(String[] words) {
		int[] answer = new int[words.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = 1;
		}
		for (int i = 0; i < words.length; i++) {
			int mo = 0;
			int ja = 0;
			int same = 1;
			int plusOne = 1;
			int minusOne = 1;
			char beforeChar = 0;
			for (int j = 0; j < words[i].length(); j++) {
				char c = words[i].charAt(j);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					ja = 0;
					mo++;
				} else {
					mo = 0;
					ja++;
				}
				if(c == beforeChar) {
					same++;
				} else {
					same = 1;
				}
				if(c + 1 == beforeChar) {
					plusOne++;
				} else {
					plusOne = 1;
				}
				if(c - 1 == beforeChar) {
					minusOne++;
				} else {
					minusOne = 1;
				}
				beforeChar = c;
				System.out.println(words[i]);
				System.out.println(same);
				System.out.println();
				if(mo >= 4 || ja >= 4 || same >= 3 || minusOne >= 4 || plusOne >= 4)
					answer[i] = 0;
			}
		}
		return answer;
	}

}
