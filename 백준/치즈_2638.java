package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2638 {

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
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		que.add(new Pos(0, 0));

		int answer = 0;
		while (!que.isEmpty()) {
			answer++;
			bfs(N, M, visited, map, que);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						int cnt = 0;
						for (int j2 = 0; j2 < 4; j2++) {
							int nr = i + dr[j2];
							int nc = j + dc[j2];
							if (nr < 0 || nc < 0 || nr >= N || nc >= M)
								continue;
							if (map[nr][nc] == 2)
								cnt++;
						}
						if (cnt >= 2) {
							visited[i][j] = true;
							que.add(new Pos(i, j));
						}
					}
				}
			}
		}
		System.out.println(answer - 1);
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void bfs(int N, int M, boolean[][] visited, int[][] map, Queue<Pos> que) {
		while (!que.isEmpty()) {
			Pos p = que.poll();
			map[p.r][p.c] = 2;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
					continue;
				else if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc));
				}
			}
		}
	}

}
