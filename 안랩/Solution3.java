package 안랩;

public class Solution3 {

	public static void main(String[] args) {
		String[] bishops = { "C6" };
		System.out.println(solution(bishops));
	}

	public static int solution(String[] bishops) {
		int answer = 0;
		int[] dr = { -1, 1, -1, 1 };
		int[] dc = { -1, 1, 1, -1 };
		boolean[][] board = new boolean[8][8];
		for (int i = 0; i < bishops.length; i++) {
			int r = bishops[i].charAt(1) - '0' - 1;
			int c = bishops[i].charAt(0) - 'A';
			board[r][c] = true;
			for (int j = 0; j < 4; j++) {
				int len = 1;
				while (true) {
					int nr = r + dr[j] * len;
					int nc = c + dc[j] * len;
					if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8)
						break;
					board[nr][nc] = true;
					len++;
				}

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!board[i][j])
					answer++;
			}
		}
		return answer;
	}

}
