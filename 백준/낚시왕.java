package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 낚시왕 {

	static class Pos {
		int r;
		int c;
		int s;
		int d;
		int z;

		Pos(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Pos[][] map = new Pos[R][C];
		ArrayList<Pos> sharks = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()) - 1; // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			Pos p = new Pos(r, c, s, d, z);
			sharks.add(p);
			map[r][c] = p;
		}
		int answer = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (map[j][i] != null) {
					answer += map[j][i].z;
					sharks.remove(map[j][i]);
					map[j][i] = null;
					break;
				}
			}
			map = new Pos[R][C];
			Queue<Pos> remove = new LinkedList<>();
			for (int s = 0; s < sharks.size(); s++) {
				Pos p = sharks.get(s);
				int nr = p.r + dr[p.d] * p.s;
				int nc = p.c + dc[p.d] * p.s;
				while (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					if (nr < 0) {
						p.d++;
						nr = Math.abs(nr);
					} else if (nc < 0) {
						p.d--;
						nc = Math.abs(nc);
					} else if (nr >= R) {
						p.d--;
						nr = (R - 1) - (nr - (R - 1));
					} else if (nc >= C) {
						p.d++;
						nc = (C - 1) - (nc - (C - 1));
					}
				}
				p.r = nr;
				p.c = nc;
				if (map[p.r][p.c] != null) {
					if (map[p.r][p.c].z > p.z) {
						sharks.remove(p);
						s--;
					} else {
						remove.add(map[p.r][p.c]);
						map[p.r][p.c] = p;
					}
				} else
					map[p.r][p.c] = p;
			}
			while (!remove.isEmpty()) {
				sharks.remove(remove.poll());
			}
		}
		System.out.println(answer);
	}

}
