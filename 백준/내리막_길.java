package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막_길 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dfs(map, M, N, 0, 0);
		System.out.println(dp[0][0]);
	}
	static int[][] dp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static int dfs(int[][] map, int M, int N, int r, int c) {
		if(dp[r][c] != -1)
			return dp[r][c];
		if( r == M - 1  && c == N - 1 )
			return 1;
		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if( nr < 0 || nc < 0 || nr >= M || nc >= N )
				continue;
			else if(map[nr][nc] < map[r][c]) {
				dp[r][c] += dfs(map, M, N, nr, nc);
			}
		}
		return dp[r][c];
	}

}
