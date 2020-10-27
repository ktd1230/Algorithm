package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 마법사_상어와_파이어볼 {

	static class Pos {
		int r;
		int c;
		int m;
		int s;
		int d;

		Pos(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Pos> ball = new ArrayList<>();
		ArrayList<Pos>[][] map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Pos p = new Pos(r, c, m, s, d);
			ball.add(p);
		}

		for (int t = 0; t < K; t++) {
			ArrayList<Pos> remove = new ArrayList<>();
			for (Pos p : ball) {
				int nr = (p.r + dr[p.d] * p.s) % N >= 0 ? (p.r + dr[p.d] * p.s) % N : N + (p.r + dr[p.d] * p.s) % N;
				int nc = (p.c + dc[p.d] * p.s) % N >= 0 ? (p.c + dc[p.d] * p.s) % N : N + (p.c + dc[p.d] * p.s) % N;
				p.r = nr;
				p.c = nc;
				map[nr][nc].add(p);
				if (map[nr][nc].size() > 1)
					remove.add(new Pos(nr, nc, 0, 0, 0));
			}
			
			for (int i = 0; i < remove.size(); i++) {
				Pos p = remove.get(i);
				if(map[p.r][p.c].isEmpty())
					continue;
				int mSum = 0;
				int sSum = 0;
				int isEven = 0;
				for (int j = 0; j < map[p.r][p.c].size(); j++) {
					mSum += map[p.r][p.c].get(j).m;
					sSum += map[p.r][p.c].get(j).s;
					if(map[p.r][p.c].get(j).d % 2 == 0)
						isEven++;
				}
				int nm = mSum / 5;
				int ns = sSum / map[p.r][p.c].size();
				if (nm > 0) {
					if (isEven == 0 || isEven == map[p.r][p.c].size()) {
						for (int j = 0; j < 8; j += 2) {
							Pos np = new Pos(p.r, p.c, nm, ns, j);
							ball.add(np);
						}
					} else {
						for (int j = 1; j < 8; j += 2) {
							Pos np = new Pos(p.r, p.c, nm, ns, j);
							ball.add(np);
						}
					}
				}
				for (Pos pos : map[p.r][p.c]) {
					ball.remove(pos);
				}
				map[p.r][p.c].clear();
			}
			for (int i = 0; i < ball.size(); i++) {
				Pos p = ball.get(i);
				map[p.r][p.c].clear();
			}
		}
		int answer = 0;
		for (int i = 0; i < ball.size(); i++) {
			answer += ball.get(i).m;
		}
		System.out.println(answer);
	}

}
