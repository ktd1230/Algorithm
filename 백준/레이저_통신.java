package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 레이저_통신 {

	static class Pos{
		int r;
		int c;
		int d;
		int cnt;

		Pos(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		Pos[] laser = new Pos[2];
		int idx = 0;
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'C') {
					laser[idx++] = new Pos(i, j, -1, -1);
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] tmp = new int[H][W];
		visited[laser[0].r][laser[0].c] = true;
		que.add(laser[0]);
		int answer = 987654321;
		while (!que.isEmpty()) {
			Pos p = que.poll();
			if (p.r == laser[1].r && p.c == laser[1].c) {
				answer = Math.min(answer, p.cnt);
			}
			for (int i = 0; i < 4; i++) {
				int nd = i;
				int nr = p.r + dr[nd];
				int nc = p.c + dc[nd];
				if (nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;
				else if ((!visited[nr][nc] || (p.d != nd && tmp[nr][nc] >= p.cnt + 1) || (p.d == nd && tmp[nr][nc] >= p.cnt)) && map[nr][nc] != '*') {
					visited[nr][nc] = true;
					if (p.d == nd) {
						que.add(new Pos(nr, nc, nd, p.cnt));
						tmp[nr][nc] = p.cnt;
					} else {
						que.add(new Pos(nr, nc, nd, p.cnt + 1));
						tmp[nr][nc] = p.cnt + 1;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
