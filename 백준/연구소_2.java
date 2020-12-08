package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소_2 {
	static int N;
	static int[][] map;
	
	static class Virus {
		int r;
		int c;
		int time;

		Virus(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();

		map = new int[N][N];
		ArrayList<Virus> vlist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					vlist.add(new Virus(i, j, 0));
					cnt++;
				}
				else if(map[i][j] == 0)
					cnt++;
			}
		}
		Virus[] sel = new Virus[M];
		comb(vlist, sel, 0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}
	static int cnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min = Integer.MAX_VALUE;

	static void comb(ArrayList<Virus> vlist, Virus[] sel, int idx, int r) {
		if (r == sel.length) {
			Queue<Virus> que = new LinkedList<>();
			int[][] tmp = new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, tmp[i], 0, N);
			}

			for (Virus virus : sel) {
				que.add(virus);
				tmp[virus.r][virus.c] = -1;
			}
			int max = 0;
			while (!que.isEmpty()) {
				Virus v = que.poll();

				for (int i = 0; i < 4; i++) {
					int nr = v.r + dr[i];
					int nc = v.c + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					else if (tmp[nr][nc] != 1 && tmp[nr][nc] >= 0) {
						que.add(new Virus(nr, nc, v.time - 1));
						tmp[nr][nc] = v.time - 1;
						if (max < -(v.time - 1))
							max = -(v.time - 1);
					}
				}
			}

			boolean check = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(tmp[i][j] == 0) {
						check = false;
						break;
					}
				}
				if(!check)
					break;
			}
			if(check && min > max)
				min = max;
			return;
		}
		if (idx == vlist.size())
			return;

		sel[r] = vlist.get(idx);
		comb(vlist, sel, idx + 1, r + 1);

		comb(vlist, sel, idx + 1, r);
	}

}
