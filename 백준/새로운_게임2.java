package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 새로운_게임2 {

	static class Pos {
		int r;
		int c;
		int d;

		Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Pos>[][] pos = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pos[i][j] = new ArrayList<>();
			}
		}
		
		ArrayList<Pos> horses = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			Pos p = new Pos(r, c, d);
			horses.add(p);
			pos[r][c].add(p);
		}
		
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };
		int answer = -1;
		int cnt = 0;
		while(answer == -1 && cnt <= 1000) {
			cnt++;
			for (Pos h : horses) {
				int r = h.r;
				int c = h.c;
				int nr = h.r + dr[h.d];
				int nc = h.c + dc[h.d];
				// 밖으로 나가거나 파란색 일때 => 방향을 반대로 하고 => 다시 이 조건이 아니면 이동, 다시 이 조건이면 그대로
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2) {
					h.d = h.d % 2 == 0 ? h.d + 1 : h.d - 1;
					nr = h.r + dr[h.d];
					nc = h.c + dc[h.d];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2)
						continue;
				}
				// 흰색 일때 => 그 위에 있는 말 위에 쌓인다.
				if(map[nr][nc] == 0) {
					int idx = 0;
					for (int i = 0; i < pos[r][c].size(); i++) {
						if(pos[r][c].get(i) == h)
							idx = i;
					}
					for (int i = idx; i < pos[r][c].size(); i++) {
						Pos p = pos[r][c].get(i);
						pos[r][c].remove(i);
						i--;
						p.r = nr;
						p.c = nc;
						pos[nr][nc].add(p);
					}
					if(pos[nr][nc].size() >= 4) {
						answer = cnt;
						break;
					}
				}
				// 빨간색 일때 => 그 위에 있는 말 위에 거꾸로 쌓인다.
				if(map[nr][nc] == 1) {
					int idx = 0;
					for (int i = 0; i < pos[r][c].size(); i++) {
						if(pos[r][c].get(i) == h)
							idx = i;
					}
					for (int i = pos[r][c].size() - 1; i >= idx; i--) {
						Pos p = pos[r][c].get(i);
						pos[r][c].remove(i);
						p.r = nr;
						p.c = nc;
						pos[nr][nc].add(p);
					}
					if(pos[nr][nc].size() >= 4) {
						answer = cnt;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
