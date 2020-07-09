package 프로그래머스;

public class 키패드_누르기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

	static class Pos {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int[][] loc = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
				{ 2, 2 } };
		Pos right_hand = new Pos(3, 2);
		Pos left_hand = new Pos(3, 0);
		for (int i = 0; i < numbers.length; i++) {
			int right = Math.abs(loc[numbers[i]][0] - right_hand.r) + Math.abs(loc[numbers[i]][1] - right_hand.c);
			int left = Math.abs(loc[numbers[i]][0] - left_hand.r) + Math.abs(loc[numbers[i]][1] - left_hand.c);
			if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				right_hand.r = loc[numbers[i]][0];
				right_hand.c = loc[numbers[i]][1];
				answer += 'R';
			} else if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				left_hand.r = loc[numbers[i]][0];
				left_hand.c = loc[numbers[i]][1];
				answer += 'L';
			} else {
				if (right < left) {
					right_hand.r = loc[numbers[i]][0];
					right_hand.c = loc[numbers[i]][1];
					answer += 'R';
				} else if (left < right) {
					left_hand.r = loc[numbers[i]][0];
					left_hand.c = loc[numbers[i]][1];
					answer += 'L';
				} else {
					if (hand.equals("right")) {
						right_hand.r = loc[numbers[i]][0];
						right_hand.c = loc[numbers[i]][1];
						answer += 'R';
					} else {
						left_hand.r = loc[numbers[i]][0];
						left_hand.c = loc[numbers[i]][1];
						answer += 'L';
					}
				}
			}
		}
		return answer;
	}
}
