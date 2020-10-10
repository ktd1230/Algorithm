package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인성_문제_있어_물음표2개 {

	static class Pos {
		int r;
		int c;
		int f;

		Pos(int r, int c, int f) {
			this.r = r;
			this.c = c;
			this.f = f;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int O = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken()) - 1;
			int startC = Integer.parseInt(st.nextToken()) - 1;
			int endR = Integer.parseInt(st.nextToken()) - 1;
			int endC = Integer.parseInt(st.nextToken()) - 1;
			int[][] map = new int[H][W];
			for (int i = 0; i < O; i++) {
				st = new StringTokenizer(br.readLine());
				int R = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken()) - 1;
				int L = Integer.parseInt(st.nextToken());
				map[R][C] = L;
			}

			Queue<Pos> que = new LinkedList<>();
			boolean[][][] visited = new boolean[H][W][F + 1];
			que.add(new Pos(startR, startC, F));
			visited[startR][startC][F] = true;
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			boolean isOk = false;
			while (!que.isEmpty()) {
				Pos p = que.poll();
				if (p.r == endR && p.c == endC) {
					isOk = true;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (nr < 0 || nc < 0 || nr >= H || nc >= W)
						continue;
					else if (p.f >= 1 && !visited[nr][nc][p.f - 1] && map[nr][nc] <= map[p.r][p.c]) {
						visited[nr][nc][p.f - 1] = true;
						que.add(new Pos(nr, nc, p.f - 1));
					} else if (map[nr][nc] > map[p.r][p.c] && map[nr][nc] - map[p.r][p.c] <= p.f && p.f >= 1 && !visited[nr][nc][p.f - 1]) {
						visited[nr][nc][p.f - 1] = true;
						que.add(new Pos(nr, nc, p.f - 1));
					}
				}
			}
			if (isOk)
				System.out.println("잘했어!!");
			else
				System.out.println("인성 문제있어??");
		}
	}

}