package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리_만들기 {

	static class Pos {
		int r;
		int c;
		int l;

		Pos(int r, int c, int l) {
			this.r = r;
			this.c = c;
			this.l = l;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					num++;
					map[i][j] = num;
					visited[i][j] = true;
					que.add(new Pos(i, j, 0));
					while (!que.isEmpty()) {
						Pos p = que.poll();
						for (int k = 0; k < 4; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							else if(!visited[nr][nc] && map[nr][nc] == 1) {
								map[nr][nc] = num;
								visited[nr][nc] = true;
								que.add(new Pos(nr, nc, 0));
							}
						}
					}
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					visited = new boolean[N][N];
					visited[i][j] = true;
					que.add(new Pos(i, j, 0));
					while (!que.isEmpty()) {
						Pos p = que.poll();
						if((p.r != i || p.c != j) && map[p.r][p.c] != 0 && map[p.r][p.c] != map[i][j]) {
							answer = Math.min(answer, p.l);
							que.clear();
							break;
						}
						for (int k = 0; k < 4; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							else if(!visited[nr][nc] && map[nr][nc] != map[i][j]) {
								visited[nr][nc] = true;
								que.add(new Pos(nr, nc, p.l + 1));
							}
						}
					}
				}
			}
		}
		System.out.println(answer - 1);
	}

}
