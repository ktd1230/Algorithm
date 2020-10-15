package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

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

		comb(map, N, M, new int[3], 0, 0);
		System.out.println(max);
	}

	static int max;
	public static void comb(int[][] map, int N, int M, int[] sel, int idx, int r) {
		if(sel.length == r) {
			int[][] newMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, newMap[i], 0, M);
			}
			for (int i = 0; i < 3; i++) {
				int R = sel[i] / M;
				int C = sel[i] % M;
				if(newMap[R][C] == 1 || newMap[R][C] == 2)
					return;
				newMap[R][C] = 1;
			}
			Queue<Pos> que = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!visited[i][j] && newMap[i][j] == 2) {
						visited[i][j] = true;
						que.add(new Pos(i, j));
						while(!que.isEmpty()) {
							Pos p = que.poll();
							for (int k = 0; k < 4; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];
								if( nr < 0 || nc < 0 || nr >= N || nc >= M )
									continue;
								else if(!visited[nr][nc] && newMap[nr][nc] == 0) {
									newMap[nr][nc] = 2;
									visited[nr][nc] = true;
									que.add(new Pos(nr, nc));
								}
							}
						}
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(newMap[i][j] == 0)
						cnt++;
				}
			}
			max = Math.max(max, cnt);
			return;
		}
		
		for (int i = idx; i < N * M; i++) {
			sel[r] = i;
			comb(map, N, M, sel, i + 1, r + 1);
		}
	}

}
