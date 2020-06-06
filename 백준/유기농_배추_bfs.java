package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 유기농_배추_bfs {
	
	static class Pos{
		int r;
		int c;
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			Queue<Pos> que = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						ans++;
						que.add(new Pos(i, j));
						visited[i][j] = true;
						while(!que.isEmpty()) {
							Pos p = que.poll();
							for (int k = 0; k < 4; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];
								if(nr < 0 || nc < 0 || nr >= N || nc >= M)
									continue;
								else if(!visited[nr][nc] && map[nr][nc] == 1) {
									visited[nr][nc] = true;
									que.add(new Pos(nr, nc));
								}
							}
						}
					}
				}
			}
			
			System.out.println(ans);
		}
	}
}
