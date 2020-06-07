package 프로그래머스;

import java.util.Arrays;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(answers)));
	}
	public static int[] solution(int[] answers) {
		int[] answer = {};
		int[] cnt = {0, 0, 0};
		int[] person1 = {1, 2, 3, 4, 5};
		int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		for (int i = 0; i < answers.length; i++) {
			if(person1[i % 5] == answers[i])
				cnt[0]++;
			if(person2[i % 8] == answers[i])
				cnt[1]++;
			if(person3[i % 10] == answers[i])
				cnt[2]++;
		}
		int max = 0;
		for (int i : cnt) {
			max = Math.max(max, i);
		}
		int len = 0;
		for (int i : cnt) {
			if(max == i)
				len++;
		}
		answer = new int[len];
		int idx = 0;
		for (int i = 0; i < cnt.length; i++) {
			if(max == cnt[i])
				answer[idx++] = i + 1;
		}
		Arrays.sort(answer);
		return answer;
	}
}
