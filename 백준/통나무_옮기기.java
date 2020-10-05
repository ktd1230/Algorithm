package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 통나무_옮기기 {

	static class Pos {
		int r;
		int c;
		int mode;
		int time;

		Pos(int r, int c, int mode, int time) {
			this.r = r;
			this.c = c;
			this.mode = mode;
			this.time = time;
		}	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		int[] dr = { -1, 1, 0, 0, -1, 1, 1, -1 };
		int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };
		int startR = 0;
		int startC = 0;
		int startMode = 0;
		int endR = 0;
		int endC = 0;
		int endMode = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B' || map[i][j] == 'E') {
					int cnt = 0;
					int mode = 0;
					for (int j2 = 0; j2 < 4; j2++) {
						int nr = i + dr[j2];
						int nc = j + dc[j2];
						if (isOut(nr, nc, N))
							continue;
						else if (map[nr][nc] == map[i][j]) {
							cnt++;
							mode = j2;
						}
					}
					if (cnt == 2)
						if (map[i][j] == 'B') {
							startR = i;
							startC = j;
							if (mode == 1)
								startMode = 0;
							else
								startMode = 1;
						} else {
							endR = i;
							endC = j;
							if (mode == 1)
								endMode = 0;
							else
								endMode = 1;
						}
				}
			}
		}
		int answer = 0;
		Queue<Pos> que = new LinkedList<>();
		boolean[][][] visited = new boolean[N][N][2];
		visited[startR][startC][startMode] = true;
		que.add(new Pos(startR, startC, startMode, 0));
		while (!que.isEmpty()) {
			Pos p = que.poll();
			if(p.r == endR && p.c == endC && p.mode == endMode) {
				answer = p.time;
				break;
			}
			boolean isLotateP = true;
			for (int i = 0; i < 8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (isOut(nr, nc, N) || map[nr][nc] == '1') {
					isLotateP = false;
					continue;
				} else if (i < 4 && !visited[nr][nc][p.mode] && map[nr][nc] != '1') {
					if (p.mode == 0) {
						if (i < 2) {
							int nnr = nr + dr[i];
							int nnc = nc + dc[i];
							if(!isOut(nnr, nnc, N) && map[nnr][nnc] != '1') {
								visited[nr][nc][p.mode] = true;
								que.add(new Pos(nr, nc, p.mode, p.time + 1));
							}
						} else {
							boolean go = true;
							for (int k = 0; k < 2; k++) {
								int nnr = nr + dr[k];
								int nnc = nc + dc[k];
								if(isOut(nnr, nnc, N) || map[nnr][nnc] == '1')
									go = false;
							}
							if(go) {
								visited[nr][nc][p.mode] = true;
								que.add(new Pos(nr, nc, p.mode, p.time + 1));
							}
						}
					} else {
						if (i < 2) {
							boolean go = true;
							for (int k = 2; k < 4; k++) {
								int nnr = nr + dr[k];
								int nnc = nc + dc[k];
								if(isOut(nnr, nnc, N) || map[nnr][nnc] == '1')
									go = false;
							}
							if(go) {
								visited[nr][nc][p.mode] = true;
								que.add(new Pos(nr, nc, p.mode, p.time + 1));
							}
						} else {
							int nnr = nr + dr[i];
							int nnc = nc + dc[i];
							if(!isOut(nnr, nnc, N) && map[nnr][nnc] != '1') {
								visited[nr][nc][p.mode] = true;
								que.add(new Pos(nr, nc, p.mode, p.time + 1));
							}
						}
					}
				}
			}
			
			if(!visited[p.r][p.c][p.mode == 1 ? 0 : 1] && isLotateP) {
				visited[p.r][p.c][p.mode == 1 ? 0 : 1] = true;
				que.add(new Pos(p.r, p.c, p.mode == 1 ? 0 : 1, p.time + 1));
			}
		}
		System.out.println(answer);
	}

	static boolean isOut(int r, int c, int N) {
		if (r < 0 || c < 0 || r >= N || c >= N)
			return true;
		return false;
	}

}
