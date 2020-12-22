package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이_차오른다_가자 {

	static class Pos {
		int r;
		int c;
		int[] keys;
		int time;

		public Pos(int r, int c, int[] key, int time) {
			this.r = r;
			this.c = c;
			keys = new int[6];
			System.arraycopy(key, 0, keys, 0, 6);
			this.time = time;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] maze = new char[N][M];
		Pos minsik = null;
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == '0') {
					minsik = new Pos(i, j, new int[6], 0);
					maze[i][j] = '.';
				}
			}
		}

		Queue<Pos> que = new LinkedList<>();
		boolean[][][][][][][][] visited = new boolean[2][2][2][2][2][2][N][M];

		que.add(minsik);
		visited[0][0][0][0][0][0][minsik.r][minsik.c] = true;

		int min = Integer.MAX_VALUE;
		while (!que.isEmpty()) {
			Pos p = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				else if (!visited[p.keys[0]][p.keys[1]][p.keys[2]][p.keys[3]][p.keys[4]][p.keys[5]][nr][nc]
						&& maze[nr][nc] == '.') {
					visited[p.keys[0]][p.keys[1]][p.keys[2]][p.keys[3]][p.keys[4]][p.keys[5]][nr][nc] = true;
					que.add(new Pos(nr, nc, p.keys, p.time + 1));

				} else if (!visited[p.keys[0]][p.keys[1]][p.keys[2]][p.keys[3]][p.keys[4]][p.keys[5]][nr][nc]
						&& maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') {
					visited[p.keys[0]][p.keys[1]][p.keys[2]][p.keys[3]][p.keys[4]][p.keys[5]][nr][nc] = true;
					int[] key = new int[6];
					System.arraycopy(p.keys, 0, key, 0, 6);
					key[maze[nr][nc] - 'a'] = 1;
					que.add(new Pos(nr, nc, key, p.time + 1));
				} else if (!visited[p.keys[0]][p.keys[1]][p.keys[2]][p.keys[3]][p.keys[4]][p.keys[5]][nr][nc]
						&& maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') {
					int dif = 'a' - 'A';
					int door = maze[nr][nc] - 'a' + dif;

					if (p.keys[door] == 1) {
						visited[p.keys[0]][p.keys[1]][p.keys[2]][p.keys[3]][p.keys[4]][p.keys[5]][nr][nc] = true;
						que.add(new Pos(nr, nc, p.keys, p.time + 1));
					}
				} else if (maze[nr][nc] == '1') {
					min = Math.min(min, p.time + 1);
				}
			}
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

}