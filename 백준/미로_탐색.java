package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {
	
	static class Pos {
		int r;
		int c;
		int t;
		Pos (int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		que.add(new Pos(0, 0, 1));
		int answer = 0;
		while(!que.isEmpty()) {
			Pos p = que.poll();
			if(p.r == N - 1 && p.c == M - 1) {
				answer = p.t;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if( nr < 0 || nc < 0 || nr >= N || nc >= M )
					continue;
				else if(!visited[nr][nc] && map[nr][nc] == '1') {
					visited[nr][nc] = true;
					que.add(new Pos(nr, nc, p.t + 1));
				}
			}
		}
		System.out.println(answer);
	}

}
