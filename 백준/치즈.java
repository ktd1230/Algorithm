package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {

	static class Pos {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cheese++;
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		que.add(new Pos(0, 0));
		Queue<Pos> resQue = new LinkedList<>();
		int cnt = 0;
		int ans = cheese;
		while (cheese != 0) {
			cnt++;
			ans = cheese;
			while (!que.isEmpty()) {
				Pos p = que.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					else if (!visited[nr][nc] && arr[nr][nc] == 0) {
						visited[nr][nc] = true;
						que.add(new Pos(nr, nc));
					} else if (!visited[nr][nc] && arr[nr][nc] == 1) {
						visited[nr][nc] = true;
						resQue.add(new Pos(nr, nc));
					}
				}
			}
			while (!resQue.isEmpty()) {
				Pos p = resQue.poll();
				arr[p.r][p.c] = 0;
				cheese--;
				que.add(p);
			}
		}
		System.out.println(cnt);
		System.out.println(ans);
	}

}
