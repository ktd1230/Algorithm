package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 어른_상어 {

	static class Pos {
		int n;
		int r;
		int c;
		int d;
		int t;

		Pos(int n, int r, int c, int t) {
			this.n = n;
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		ArrayList<Pos> sharks = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					sharks.add(new Pos(map[i][j], i, j, 0));
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		Collections.sort(sharks, new Comparator<Pos>() {
			public int compare(Pos o1, Pos o2) {
				return o1.n - o2.n;
			}
		});
		for (int i = 0; i < M; i++) {
			sharks.get(i).d = Integer.parseInt(st.nextToken()) - 1;
		}
		int[][][] sharkD = new int[M][4][4];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < 4; j2++) {
					sharkD[i][j][j2] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		int answer = 0;
		ArrayList<Pos> smell = new ArrayList<>();
		for (int t = 1; t <= 1000; t++) {
			// 냄새 시간증가
			for (int i = 0; i < smell.size(); i++) {
				Pos p = smell.get(i);
				p.t++;
				map[p.r][p.c] = p.n;
				if (p.t >= k) {
					map[p.r][p.c] = 0;
					smell.remove(i);
					i--;
				}
			}

			// 자신의 위치에 냄새를 뿌림 -> 냄새는 k번 이동하면 사라짐
			for (int i = 0; i < sharks.size(); i++) {
				Pos p = sharks.get(i);
				smell.add(new Pos(p.n, p.r, p.c, 0));
				// 아무 냄새 없는 칸으로 이동
				boolean isNoSmell = false;
				for (int j = 0; j < 4; j++) {
					int nr = p.r + dr[sharkD[p.n - 1][p.d][j]];
					int nc = p.c + dc[sharkD[p.n - 1][p.d][j]];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					else if (map[nr][nc] == 0) {
						isNoSmell = true;
						p.r = nr;
						p.c = nc;
						p.d = sharkD[p.n - 1][p.d][j];
						break;
					}
				}
				// 그런칸이 없으면 자신의 냄새가 있는 칸으로 이동
				// 이때, 우선순위는 상어마다 다름
				if (!isNoSmell) {
					for (int j = 0; j < 4; j++) {
						int nr = p.r + dr[sharkD[p.n - 1][p.d][j]];
						int nc = p.c + dc[sharkD[p.n - 1][p.d][j]];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;
						else if (map[nr][nc] == p.n) {
							p.r = nr;
							p.c = nc;
							p.d = sharkD[p.n - 1][p.d][j];
							break;
						}
					}
				}
			}
			// 상어이동 완료 후 겹쳐있으면 가장 작은 숫자의 상어가 살아남음
			for (int i = 0; i < sharks.size(); i++) {
				for (int j = i + 1; j < sharks.size(); j++) {
					if (sharks.get(i).r == sharks.get(j).r && sharks.get(i).c == sharks.get(j).c) {
						if (sharks.get(i).n < sharks.get(j).n) {
							sharks.remove(j);
							j--;
						} else {
							sharks.remove(i);
							i--;
						}
					}
				}
			}
			for (Pos p : sharks) {
				map[p.r][p.c] = p.n; 
			}

			// 1번 상어만 살아남을 때 까지 반복 -> 답은 이때까지 걸리는 시간. 만약 1000초 이상이면 -1
			if (sharks.size() == 1) {
				answer = t;
				break;
			}

		}
		System.out.println(answer == 0 ? -1 : answer);
	}

}
