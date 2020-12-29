package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의_개수 {
	
	static class Pos {
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if(h == 0 && w == 0)
				break;
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			
			Queue<Pos> que = new LinkedList<>();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						cnt++;
						visited[i][j] = true;
						que.add(new Pos(i, j));
						while(!que.isEmpty()) {
							Pos p = que.poll();
							for (int k = 0; k < 8; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];
								if(nr < 0 || nc < 0 || nr >= h || nc >= w)
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
			System.out.println(cnt);
		}
	}
	
}
