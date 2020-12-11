package 백준;

import java.util.Scanner;

public class 주사위_굴리기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };
		int[] dice = new int[6];
		for (int i = 0; i < K; i++) {
			int d = sc.nextInt() - 1;
			int nr = x + dr[d];
			int nc = y + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			else {
				int tmp = dice[4];
				dice[4] = dice[d];
				dice[d] = dice[5];
				dice[5] = dice[d % 2 == 0 ? d + 1 : d - 1];
				dice[d % 2 == 0 ? d + 1 : d - 1] = tmp;
				if (map[nr][nc] == 0)
					map[nr][nc] = dice[4];
				else {
					dice[4] = map[nr][nc];
					map[nr][nc] = 0;
				}
				x = nr;
				y = nc;
				System.out.println(dice[5]);
			}
		}
	}
}
