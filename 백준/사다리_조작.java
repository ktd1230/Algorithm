package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리_조작 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][N];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = i;
			map[a][b + 1] = i;
		}
		dfs(map, N, H, 0, M + 1, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static int[] dr = { 0, 0 };
	static int[] dc = { -1, 1 };

	static int min = Integer.MAX_VALUE;

	static void dfs(int[][] map, int N, int H, int cnt, int num, int pos) {
		if (cnt > min || cnt > 3)
			return;
		boolean check = true;
		for (int i = 0; i < N; i++) {
			int R = 0;
			int C = i;
			while (R < H) {
				if (map[R][C] != 0) {
					for (int j = 0; j < 2; j++) {
						int nr = R + dr[j];
						int nc = C + dc[j];
						if (nr < 0 || nc < 0 || nr >= H || nc >= N)
							continue;
						if (map[R][C] == map[nr][nc]) {
							R = nr;
							C = nc;
							break;
						}
					}
				}
				R++;
			}
			if (C != i)
				check = false;
		}
		if (check) {
			min = Math.min(min, cnt);
			return;
		}

		for (int i = pos; i < H * (N - 1); i++) {
			int r = i / (N - 1);
			int c = i % (N - 1);
			if (map[r][c] == 0 && map[r][c + 1] == 0) {
				map[r][c] = num;
				map[r][c + 1] = num;
				dfs(map, N, H, cnt + 1, num + 1, i);
				map[r][c] = 0;
				map[r][c + 1] = 0;
			}
		}
	}
}
