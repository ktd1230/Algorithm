package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟 {
	
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		int smash;
		public Pos(int r, int c, int smash) {
			this.r = r;
			this.c = c;
			this.smash = smash;
		}
		public int compareTo(Pos o) {
			return smash - o.smash;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		PriorityQueue<Pos> que = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][M];
		que.add(new Pos(0, 0, 0));
		
		int min = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			Pos p = que.poll();
			if(p.r == N - 1 && p.c == M - 1)
				min = Math.min(min, p.smash);
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				else if(!visited[nr][nc] && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc, p.smash));
				} else if(!visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc, p.smash + 1));
				}
			}
			
		}
		
		System.out.println(min);
		
	}
	
}
