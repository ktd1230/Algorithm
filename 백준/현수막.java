package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현수막 {
	
	static class Pos {
		int r;
		int c;
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] pan = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		int ans = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && pan[i][j] == 1) {
					ans++;
					visited[i][j] = true;
					que.add(new Pos(i, j));
					while(!que.isEmpty()) {
						Pos p = que.poll();
						for (int k = 0; k < 8; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= M || nc >= N)
								continue;
							else if(!visited[nr][nc] && pan[nr][nc] == 1) {
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
