package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링_2 {

	static class Pos {
		int r;
		int c;
		int n;

		Pos(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = Integer.MAX_VALUE;
		int[] dr = { 1, 1, -1, -1 };
		int[] dc = { -1, 1, 1, -1 };
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						int nr = i;
						int nc = j;
						int[][] newMap = new int[N][N];
						int d = 0;
						boolean check = true;
						for (int k = 0; k < 2 * (d1 + d2); k++) {
							if (k == d1 || k == d1 + d2 || k == d1 + d2 + d1) {
								if (k == d1) {
									int nnc = nc - 1;
									while (true) {
										if (nnc < 0)
											break;
										newMap[nr][nnc] = 3;
										nnc--;
									}
								} else if (k == d1 + d2) {
									int nnr = nr + 1;
									while (true) {
										if (nnr >= N)
											break;
										newMap[nnr][nc] = 4;
										nnr++;
									}
								} else if (k == 2 * d1 + d2) {
									int nnc = nc + 1;
									while (true) {
										if (nnc >= N)
											break;
										newMap[nr][nnc] = 2;
										nnc++;
									}
								}
								d++;
							}
							nr += dr[d];
							nc += dc[d];
							if (k == 2 * (d1 + d2) - 1) {
								int nnr = nr - 1;
								while (true) {
									if (nnr < 0)
										break;
									newMap[nnr][nc] = 1;
									nnr--;
								}
							}
							if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
								check = false;
								break;
							}
							newMap[nr][nc] = 5;
						}
						Queue<Pos> que = new LinkedList<>();
						que.add(new Pos(0, 0, 1));
						que.add(new Pos(0, N - 1, 2));
						que.add(new Pos(N - 1, 0, 3));
						que.add(new Pos(N - 1, N - 1, 4));
						int[] qdr = { 0, 0, -1, 1 };
						int[] qdc = { -1, 1, 0, 0 };
						while(!que.isEmpty()) {
							Pos p = que.poll();
							for (int l = 0; l < 4; l++) {
								int qnr = p.r + qdr[l];
								int qnc = p.c + qdc[l];
								if(qnr < 0 || qnc < 0 || qnr >= N || qnc >= N)
									continue;
								else if(newMap[qnr][qnc] == 0) {
									newMap[qnr][qnc] = p.n;
									que.add(new Pos(qnr, qnc, p.n));
								}
							}
						}
						int[] people = new int[5];
						if (check) {
							for (int k = 0; k < N; k++) {
								for (int k2 = 0; k2 < N; k2++) {
									if(newMap[k][k2] == 0 || newMap[k][k2] == 5)
										people[4] += map[k][k2];
									else
										people[newMap[k][k2] - 1] += map[k][k2];
								}
							}
							Arrays.sort(people);
							answer = Math.min(answer, people[4] - people[0]);
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
