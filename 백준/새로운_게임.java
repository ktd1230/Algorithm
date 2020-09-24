package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 새로운_게임 {
	
	static class Horse {
		int n;
		int r;
		int c;
		int d;
		Horse(int n, int r, int c, int d) {
			this.n = n;
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
		
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };
		ArrayList<Horse> horses = new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			
			horses.add(new Horse(i, r, c, d));
		}
		ArrayList<Horse>[][] position = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				position[i][j] = new ArrayList<>();
			}
		}
		for (Horse h : horses) {
			position[h.r][h.c].add(h);
		}
		int cnt = 0;
		out: while(true) {
			if(cnt > 1000)
				break;
			cnt++;
			for (Horse h : horses) {
				if(position[h.r][h.c].get(0).n != h.n)
					continue;
				int nr = h.r + dr[h.d];
				int nc = h.c + dc[h.d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2) {
					if(h.d % 2 == 0)
						h.d++;
					else
						h.d--;
					nr = h.r + dr[h.d];
					nc = h.c + dc[h.d];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2)
						continue;
					
				} if(map[nr][nc] == 0) {
					int size = position[h.r][h.c].size();
					int lr = h.r;
					int lc = h.c;
					for (int i = 0; i < size; i++) {
						Horse horse = position[lr][lc].get(i);
						horse.r = nr;
						horse.c = nc;
						position[nr][nc].add(horse);
					}
					if(position[nr][nc].size() >= 4)
						break out;
					position[lr][lc].clear();
				} else if(map[nr][nc] == 1) {
					int size = position[h.r][h.c].size();
					int lr = h.r;
					int lc = h.c;
					for (int i = size - 1; i >= 0; i--) {
						Horse horse = position[lr][lc].get(i);
						horse.r = nr;
						horse.c = nc;
						position[nr][nc].add(horse);
					}
					if(position[nr][nc].size() >= 4)
						break out;
					position[lr][lc].clear();
				}
			}
		}
		System.out.println(cnt > 1000 ? -1 : cnt);
	}

}
