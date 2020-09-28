package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baaaaaaaaaduk2_Easy {
	
	static class Pos {
		int r;
		int c;
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] pan = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(pan, N, M, 0);
		System.out.println(max);
	}
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max;
	public static void dfs(int[][] pan, int N, int M, int cnt) {
		if(cnt == 2) {
			int count = 0;
			Queue<Pos> que = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int tmp = 0;
					boolean isScore = true;
					if(!visited[i][j] && pan[i][j] == 2) {
						visited[i][j] = true;
						que.add(new Pos(i, j));
						while(!que.isEmpty()) {
							Pos p = que.poll();
							tmp++;
							for (int k = 0; k < 4; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];
								if(nr < 0 || nc < 0 || nr >= N || nc >= M)
									continue;
								else if(!visited[nr][nc] && pan[nr][nc] == 2) {
									visited[nr][nc] = true;
									que.add(new Pos(nr, nc));
								} else if(pan[nr][nc] == 0)
									isScore = false;
							}
						}
					}
					if(isScore)
						count += tmp;
				}
			}
			max = Math.max(max, count);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(pan[i][j] == 0) {
					pan[i][j] = 1;
					dfs(pan, N, M, cnt + 1);
					pan[i][j] = 0;
				}
			}
		}
		
	}

}
