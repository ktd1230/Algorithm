package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미네랄 {

	static class Pos implements Comparable<Pos> {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int compareTo(Pos o) {
			return o.r - r;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] cave = new char[R][C];
		for (int i = 0; i < R; i++) {
			cave[i] = br.readLine().toCharArray();
		}

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int r = Integer.parseInt(st.nextToken());
			if (i % 2 == 0) {
				for (int j = 0; j < C; j++) {
					if (cave[R - r][j] == 'x') {
						cave[R - r][j] = '.';
						break;
					}
				}
			} else {
				for (int j = C - 1; j >= 0; j--) {
					if (cave[R - r][j] == 'x') {
						cave[R - r][j] = '.';
						break;
					}
				}
			}

			Queue<Pos> que = new LinkedList<>();
			int[][] visited = new int[R][C];
			int cluster = 1;

			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					if (visited[j][j2] == 0 && cave[j][j2] == 'x') {
						ArrayList<Pos> list = new ArrayList<>();
						int maxR = j;
						que.add(new Pos(j, j2));
						visited[j][j2] = cluster;
						while (!que.isEmpty()) {
							Pos p = que.poll();
							list.add(new Pos(p.r, p.c));
							maxR = Math.max(maxR, p.r);
							for (int k = 0; k < 4; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];
								if (nr < 0 || nc < 0 || nr >= R || nc >= C)
									continue;
								else if (visited[nr][nc] == 0 && cave[nr][nc] == 'x') {
									visited[nr][nc] = cluster;
									que.add(new Pos(nr, nc));
								}
							}
						}

						if (maxR != R - 1) {
							int dif = R - 1 - maxR;
							Collections.sort(list);
							for (int k = 0; k < list.size(); k++) {
								for (int k2 = list.get(k).r + 1; k2 < R; k2++) {
									if (visited[k2][list.get(k).c] != cluster && cave[k2][list.get(k).c] == 'x') {
										dif = Math.min(dif, k2 - 1 - list.get(k).r);
										break;
									}
								}
							}
							for (int k = 0; k < list.size(); k++) {
								cave[list.get(k).r][list.get(k).c] = '.';
								cave[list.get(k).r + dif][list.get(k).c] = 'x';
								visited[list.get(k).r][list.get(k).c] = 0;
								visited[list.get(k).r + dif][list.get(k).c] = cluster;
							}
							break;
						}
						cluster++;
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(cave[i][j]);
			}
			System.out.println();
		}
	}

}
