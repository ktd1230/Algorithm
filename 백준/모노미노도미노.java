package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모노미노도미노 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[10][10];
		// 0 <= r <= 3 && 6 <= c <= 9 까지 오른쪽 파란색
		// 6 <= r <= 9 && 0 <= c <= 3 까지 아래쪽 초록색
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 블록 놓기
			int Bnr = r;
			int Bnc = c;
			int Gnr = r;
			int Gnc = c;
			switch (t) {
			case 1:
				while (true) {
					if (Bnc >= 10)
						break;
					if (board[Bnr][Bnc] != 0)
						break;
					Bnc++;
				}
				Bnc--;
				while (true) {
					if (Gnr >= 10)
						break;
					if (board[Gnr][Gnc] != 0)
						break;
					Gnr++;
				}
				Gnr--;
				board[Bnr][Bnc] = i;
				board[Gnr][Gnc] = i;
				break;
			case 2: // 왼쪽으로 하나 추가
				Bnc++;
				while (true) {
					if (Bnc >= 10)
						break;
					if (board[Bnr][Bnc] != 0)
						break;
					Bnc++;
				}
				Bnc--;
				while (true) {
					if (Gnr >= 10)
						break;
					if (board[Gnr][Gnc] != 0 || board[Gnr][Gnc + 1] != 0)
						break;
					Gnr++;
				}
				Gnr--;
				board[Bnr][Bnc] = i;
				board[Bnr][Bnc - 1] = i;
				board[Gnr][Gnc] = i;
				board[Gnr][Gnc + 1] = i;
				break;
			case 3: // 아래쪽으로 하나 추가
				while (true) {
					if (Bnc >= 10)
						break;
					if (board[Bnr][Bnc] != 0 || board[Bnr + 1][Bnc] != 0)
						break;
					Bnc++;
				}
				Bnc--;
				Gnr++;
				while (true) {
					if (Gnr >= 10)
						break;
					if (board[Gnr][Gnc] != 0)
						break;
					Gnr++;
				}
				Gnr--;
				board[Bnr][Bnc] = i;
				board[Bnr + 1][Bnc] = i;
				board[Gnr][Gnc] = i;
				board[Gnr - 1][Gnc] = i;
				break;
			}
			// 한 라인 차있는 블록 삭제 및 점수 추가
			// 삭제하고 내려오고 있으면 또 삭제 == 없을 때 까지 반복
			// 파란색 먼저
			remove(board, true);
			// 초록색
			remove(board, false);
			// 연한 곳 처리
			// 파란색 먼저
			afterRemove(board, true);
			// 초록색
			afterRemove(board, false);
		}
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cnt = board[i][j] != 0 ? cnt + 1 : cnt;
			}
		}
		System.out.println(point);
		System.out.println(cnt);
	}

	public static void down(int[][] board, boolean blue) {
		for (int j = 9; j >= 4; j--) {
			for (int j2 = 0; j2 < 4; j2++) {
				if ((blue && board[j2][j] != 0) || (!blue && board[j][j2] != 0)) {
					int len = 1;
					int r = -1;
					int c = -1;
					if (blue) {
						int nr = j2;
						int nc = j + 1;
						while (true) {
							if (nc >= 10 || board[nr][nc] != 0)
								break;
							nc++;
							len++;
						}
						nc--;
						r = j2;
						c = j;
					} else if (!blue) {
						int nr = j + 1;
						int nc = j2;
						while (true) {
							if (nr >= 10 || board[nr][nc] != 0)
								break;
							nr++;
							len++;
						}
						nr--;
						r = j;
						c = j2;
					}
					len--;
					if(len == 0)
						continue;
					int tmp = board[r][c];
					board[r][c] = 0;
					boolean isMove = true;
					boolean isOne = true;
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (blue && (nr < 0 || nc < 6 || nr >= 4 || nc >= 10))
							continue;
						else if (!blue && (nr < 6 || nc < 0 || nr >= 10 || nc >= 4))
							continue;
						else if (board[nr][nc] == tmp) {
							isOne = false;
							for (int k = 1; k <= len; k++) {
								if (blue && board[nr][nc + k] != 0)
									isMove = false;
								else if (!blue && board[nr + k][nc] != 0)
									isMove = false;
							}
							if (isMove) {
								board[nr][nc] = 0;
								if (blue) {
									board[r][c + len] = tmp;
									board[nr][nc + len] = tmp;
								} else {
									board[r + len][c] = tmp;
									board[nr + len][nc] = tmp;
								}
							} else
								board[r][c] = tmp;
							break;
						}
					}
					if (isOne) {
						if (blue)
							board[r][c + len] = tmp;
						else
							board[r + len][c] = tmp;
					}
				}
			}
		}
	}

	public static void afterRemove(int[][] board, boolean blue) {
		// 확인
		int cnt = 0;
		for (int j = 5; j >= 4; j--) {
			for (int j2 = 0; j2 < 4; j2++) {
				if (blue && board[j2][j] != 0 || !blue && board[j][j2] != 0) {
					cnt++;
					break;
				}
			}
		}
		// 연한부분 밀어내기
		for (int j = 9; j >= 6; j--) {
			for (int j2 = 0; j2 < 4; j2++) {
				if (blue)
					board[j2][j] = board[j2][j - cnt];
				else
					board[j][j2] = board[j - cnt][j2];
			}
		}
		for (int j = 5; j >= 4; j--) {
			for (int j2 = 0; j2 < 4; j2++) {
				if (blue)
					board[j2][j] = 0;
				else
					board[j][j2] = 0;
			}
		}
	}

	static int point;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void remove(int[][] board, boolean blue) {
		boolean check = false;
		while (true) {
			// 삭제
			for (int j = 9; j >= 6; j--) {
				int cnt = 0;
				for (int j2 = 0; j2 < 4; j2++) {
					if ((blue && board[j2][j] != 0) || (!blue && board[j][j2] != 0))
						cnt++;
				}
				if (cnt == 4) {
					check = true;
					point++;
					for (int j2 = 0; j2 < 4; j2++) {
						if (blue)
							board[j2][j] = 0;
						else
							board[j][j2] = 0;
					}
				}
			}
			if (!check)
				break;
			check = false;
			// 내려가기
			down(board, blue);
		}
	}

}
