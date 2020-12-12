package 백준;

import java.util.Scanner;

public class 로봇_청소기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];

		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		switch(d) {
		case 1:
			d = 3;
			break;
		case 3:
			d = 1;
			break;
		}

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, -1, 0, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		if (map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}
		boolean flag = true;
		while (flag) {
			flag = false;

			for (int i = 0; i < 4; i++) {
				int nd = (i + d + 1) % 4;
				int nr = r + dr[nd];
				int nc = c + dc[nd];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				else if (map[nr][nc] == 0) {
					map[nr][nc] = 2;
					cnt++;
					r = nr;
					c = nc;
					d = nd;
					flag = true;

					break;
				}
			}
			if (!flag) {
				int nr;
				int nc;
				switch (d) {
				case 0:
					nr = r + dr[2];
					nc = c + dc[2];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if(map[nr][nc] == 1)
						continue;
					else {
						r = nr;
						c = nc;
						flag = true;
					}
					break;
				case 1:
					nr = r + dr[3];
					nc = c + dc[3];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if(map[nr][nc] == 1)
						continue;
					else {
						r = nr;
						c = nc;
						flag = true;
					}
					break;
				case 2:
					nr = r + dr[0];
					nc = c + dc[0];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if(map[nr][nc] == 1)
						continue;
					else {
						r = nr;
						c = nc;
						flag = true;
					}
					break;
				case 3:
					nr = r + dr[1];
					nc = c + dc[1];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if(map[nr][nc] == 1)
						continue;
					else {
						r = nr;
						c = nc;
						flag = true;
					}
					break;
				}
			}
		}

		System.out.println(cnt);

	}

}
