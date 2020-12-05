package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사_상어와_파이어스톰 {
	
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
		int Q = Integer.parseInt(st.nextToken());
		int n = 1;
		for (int i = 0; i < N; i++) {
			n *= 2;
		}
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] L = new int[Q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int i = 0; i < L.length; i++) {
			for (int l = 1; l <= L[i]; l++) {
				for (int j = 0; j < n; j += Math.pow(2, l)) {
					for (int j2 = 0; j2 < n; j2 += Math.pow(2, l)) {
						for (int k = j; k < j + Math.pow(2, l - 1); k++) {
							for (int k2 = j2; k2 < j2 + Math.pow(2, l - 1); k2++) {
								int tmp = map[k][k2];
								map[k][k2] = map[(int) (k + Math.pow(2, l - 1))][k2];
								map[(int) (k + Math.pow(2, l - 1))][k2] = map[(int) (k
										+ Math.pow(2, l - 1))][(int) (k2 + Math.pow(2, l - 1))];
								map[(int) (k + Math.pow(2, l - 1))][(int) (k2
										+ Math.pow(2, l - 1))] = map[k][(int) (k2 + Math.pow(2, l - 1))];
								map[k][(int) (k2 + Math.pow(2, l - 1))] = tmp;
							}
						}
					}
				}
			}
			boolean[][] check = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nr = j + dr[k];
						int nc = j2 + dc[k];
						if (nr < 0 || nc < 0 || nr >= n || nc >= n)
							continue;
						else if (map[nr][nc] > 0)
							cnt++;
					}
					if (cnt < 3)
						check[j][j2] = true;
				}
			}

			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if (check[j][j2] && map[j][j2] > 0)
						map[j][j2]--;
				}
			}
		}
		int total = 0;
		int biggest = 0;
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					int cnt = 0;
					visited[i][j] = true;
					que.add(new Pos(i, j));
					while(!que.isEmpty()) {
						Pos p = que.poll();
						cnt++;
						for (int k = 0; k < 4; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc])
								continue;
							else if(map[nr][nc] != 0) {
								visited[nr][nc] = true;
								que.add(new Pos(nr, nc));
							}
						}
					}
					biggest = Math.max(biggest, cnt);
				}
				total += map[i][j];
			}
		}
		System.out.println(total);
		System.out.println(biggest);
	}

}
