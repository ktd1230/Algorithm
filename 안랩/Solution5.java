package 안랩;

import java.util.Arrays;

public class Solution5 {

	public static void main(String[] args) {
		int num = 8;
		int[] cards = { 1, 4, 6 };
		System.out.println(solution(num, cards));
	}

	public static int solution(int num, int[] cards) {
		int answer = 0;

		int[] D = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			D[i] = 100000;
		}

		for (int i = 0; i <= cards.length - 1; i++) {
			for (int j = cards[i]; j <= num; j++) {
				if (cards[i] == j)
					D[j] = 1;
				D[j] = Math.min(D[j], D[j - cards[i]] + 1);
			}
		}
		System.out.println(Arrays.toString(D));
		answer = D[num];
		return answer;
	}

}
