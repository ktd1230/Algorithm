package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사_상어와_토네이도 {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	static int[][][] storm = {
			{ { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, 0, 0, 0, 0 }, { 0, 10, 7, 1, 0 }, { 0, 0, 2, 0, 0 } },
			{ { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 2, 7, 0, 7, 2 }, { 0, 10, 0, 10, 0 }, { 0, 0, 5, 0, 0 } },
			{ { 0, 0, 2, 0, 0 }, { 0, 1, 7, 10, 0 }, { 0, 0, 0, 0, 5 }, { 0, 1, 7, 10, 0 }, { 0, 0, 2, 0, 0 } },
			{ { 0, 0, 5, 0, 0 }, { 0, 10, 0, 10, 0 }, { 2, 7, 0, 7, 2 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 } },

	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = N / 2;
		int c = N / 2;
		int d = 0;
		int cnt = 1;
		int num = 0;
		int answer = 0;
		out: while (true) {
			if (cnt % 2 == 1)
				num++;
			int nr = r;
			int nc = c;
			for (int i = 0; i < num; i++) {
				nr += dr[d];
				nc += dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					break out;
				int rest = map[nr][nc];
				for (int j = 0; j < 5; j++) {
					for (int j2 = 0; j2 < 5; j2++) {
						if (storm[d][j][j2] == 0)
							continue;
						int nnr = nr - 2 + j;
						int nnc = nc - 2 + j2;
						if (nnr < 0 || nnc < 0 || nnr >= N || nnc >= N)
							answer += (storm[d][j][j2] * map[nr][nc]) / 100;
						else
							map[nnr][nnc] += (storm[d][j][j2] * map[nr][nc]) / 100;
						rest -= (storm[d][j][j2] * map[nr][nc]) / 100;
					}
				}
				map[nr][nc] = 0;
				if (nr + dr[d] < 0 || nc + dc[d] < 0 || N <= nr + dr[d] || N <= nc + dc[d])
					answer += rest;
				else
					map[nr + dr[d]][nc + dc[d]] += rest;
			}
			d = (d + 1) % 4;
			r = nr;
			c = nc;
			cnt++;
		}
		System.out.println(answer);
	}

}
