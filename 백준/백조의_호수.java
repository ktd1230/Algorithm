package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의_호수 {

	static class Pos {
		int r;
		int c;
		int t;

		Pos(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		Queue<Pos> que = new LinkedList<>();
		Pos[] swan = new Pos[2];
		int idx = 0;
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					que.add(new Pos(i, j, 0));
				} else if (map[i][j] == 'L') {
					que.add(new Pos(i, j, 0));
					swan[idx++] = new Pos(i, j, 0);
				}
			}
		}
		int[][] time = new int[R][C];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int start = 987654321;
		int end = 0;
		while (!que.isEmpty()) {
			Pos p = que.poll();
			time[p.r][p.c] = p.t;
			start = Math.min(start, p.t);
			end = Math.max(end, p.t);
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				else if (!visited[nr][nc] && map[nr][nc] != 'X') {
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc, p.t));
				} else if (!visited[nr][nc] && map[nr][nc] == 'X') {
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc, p.t + 1));
				}
			}
		}
		while (start < end) {
			int mid = (start + end) / 2;
			Queue<Pos> tmp = new LinkedList<>();
			visited = new boolean[R][C];
			visited[swan[0].r][swan[0].c] = true; 
			tmp.add(swan[0]);
			boolean isMeet = false;
			while (!tmp.isEmpty()) {
				Pos p = tmp.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C || time[nr][nc] > mid)
						continue;
					else if (!visited[nr][nc] && map[nr][nc] == 'L') {
						isMeet = true;
						break;
					} else if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						tmp.add(new Pos(nr, nc, 0));
					}
				}
			}
			if(isMeet)
				end = mid;
			else
				start = mid + 1;
		}
		System.out.println(start);
	}

}
