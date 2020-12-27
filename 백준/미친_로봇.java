package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미친_로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[2 * N + 1][2 * N + 1];
		double[] P = new double[4];
		for (int i = 0; i < 4; i++) {
			P[i] = Double.parseDouble(st.nextToken()) / 100;
		}
		map[N][N] = 1;
		dfs(P, map, 0, N, N, N, 1, false);
		System.out.println(ans);
	}

	static double ans;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void dfs(double[] P, int[][] map, int depth, int N, int r, int c, double percent, boolean check) {
		if (depth == N) {
			if (!check)
				ans += percent;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			boolean newCheck = check;
			int tmp = map[nr][nc];
			if (map[nr][nc] == 1)
				newCheck = true;
			map[nr][nc] = 1;
			double newPercent = percent * P[i];
			dfs(P, map, depth + 1, N, nr, nc, newPercent, newCheck);
			map[nr][nc] = tmp;
		}
	}

}
