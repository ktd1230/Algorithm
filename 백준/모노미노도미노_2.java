package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모노미노도미노_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[10][10];
		int point = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int nr = r;
			int nc = c;
			while (true) {
				nr++;
				if (t != 2 && (nr >= 10 || board[nr][nc] != 0)) {
					nr--;
					break;
				} else if (t == 2 && (nr >= 10 || board[nr][nc] != 0 || board[nr][nc + 1] != 0)) {
					nr--;
					break;
				}
			}
			board[nr][nc] = 1;
			if (t == 2)
				board[nr][nc + 1] = 1;
			else if (t == 3)
				board[nr - 1][nc] = 1;
			nr = r;
			while (true) {
				nc++;
				if (t != 3 && (nc >= 10 || board[nr][nc] != 0)) {
					nc--;
					break;
				} else if (t == 3 && (nc >= 10 || board[nr][nc] != 0 || board[nr + 1][nc] != 0)) {
					nc--;
					break;
				}
			}
			if (t == 2)
				board[nr][nc - 1] = 1;
			else if (t == 3)
				board[nr + 1][nc] = 1;
			board[nr][nc] = 1;

			for (int j = 6; j < 10; j++) {
				int cnt = 0;
				for (int j2 = 0; j2 < 4; j2++) {
					if (board[j][j2] == 1)
						cnt++;
				}
				if (cnt == 4) {
					point++;
					for (int k = j; k >= 4; k--) {
						for (int k2 = 0; k2 < 4; k2++) {
							board[k][k2] = board[k - 1][k2];
						}
					}
					j--;
				}
			}

			for (int j = 6; j < 10; j++) {
				int cnt = 0;
				for (int j2 = 0; j2 < 4; j2++) {
					if (board[j2][j] == 1)
						cnt++;
				}
				if (cnt == 4) {
					point++;
					for (int k = j; k >= 4; k--) {
						for (int k2 = 0; k2 < 4; k2++) {
							board[k2][k] = board[k2][k - 1];
						}
					}
					j--;
				}
			}
			int cnt = 0;
			for (int j = 4; j < 6; j++) {
				boolean check = false;
				for (int j2 = 0; j2 < 4; j2++) {
					if (board[j][j2] == 1)
						check = true;
				}
				if (check)
					cnt++;
			}
			if (cnt != 0) {
				for (int j = 9; j >= 6 - cnt; j--) {
					for (int j2 = 0; j2 < 4; j2++) {
						board[j][j2] = board[j - cnt][j2];
					}
				}
			}
			cnt = 0;
			for (int j = 4; j < 6; j++) {
				boolean check = false;
				for (int j2 = 0; j2 < 4; j2++) {
					if (board[j2][j] == 1)
						check = true;
				}
				if (check)
					cnt++;
			}

			if (cnt != 0) {
				for (int j = 9; j >= 6 - cnt; j--) {
					for (int j2 = 0; j2 < 4; j2++) {
						board[j2][j] = board[j2][j - cnt];
					}
				}
			}
		}
		for (int j = 0; j < 10; j++) {
			for (int j2 = 0; j2 < 10; j2++) {
				if (board[j][j2] == 1)
					count++;
			}
		}
		System.out.println(point);
		System.out.println(count);
	}

}
