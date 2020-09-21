package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 움직이는_미로_탈출 {
	
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
		char[][] pan = new char[8][8];
		int answer = 0;
		for (int i = 0; i < 8; i++) {
			pan[i] = br.readLine().toCharArray();
		}
		int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[8][8];
		visited[7][0] = true;
		que.add(new Pos(7, 0));
		out: while(!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Pos p = que.poll();
                if(pan[p.r][p.c] == '#') {
					visited[p.r][p.c] = false;
					continue;
				}
				if(p.r == 0 && p.c == 7) {
					answer = 1;
					break out;
				}
				for (int k = 0; k < 8; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(nr < 0 || nc < 0 || nr >= 8 || nc >= 8)
						continue;
					else if(!visited[nr][nc] && pan[nr][nc] == '.') {
						visited[nr][nc] = true;
						que.add(new Pos(nr, nc));
					}
				}
                que.add(p);
			}
			for (int i = 7; i >= 0; i--) {
				for (int j = 0; j < 8; j++) {
					if(pan[i][j] == '#') {
						pan[i][j] = '.';
						if(i + 1 < 8)
							pan[i + 1][j] = '#';
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
