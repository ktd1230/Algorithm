package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	
	static class Pos {
		int h;
		int r;
		int c;
		int t;
		Pos (int h, int r, int c, int t){
			this.h = h;
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] box = new int[H][N][M];
		int yet = 0;
		Queue<Pos> que = new LinkedList<>();
		boolean[][][] visited = new boolean[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < M; j2++) {
					box[i][j][j2] = Integer.parseInt(st.nextToken());
					if(box[i][j][j2] == 1) {
						visited[i][j][j2] = true;
						que.add(new Pos(i, j, j2, 0));
					} else if(box[i][j][j2] == 0)
						yet++;
				}
			}
		}
		
		int[] dr = { -1, 1, 0, 0, 0, 0 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };
		int[] dh = { 0, 0, 0, 0, -1, 1 };
		int answer = yet == 0 ? 0 : -1;
		while(!que.isEmpty()) {
			Pos p = que.poll();
			if(yet == 0)
				break;
			for (int i = 0; i < 6; i++) {
				int nh = p.h + dh[i];
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if( nr < 0 || nc < 0 || nh < 0 || nr >= N || nc >= M || nh >= H )
					continue;
				else if(!visited[nh][nr][nc] && box[nh][nr][nc] == 0) {
					visited[nh][nr][nc] = true;
					que.add(new Pos(nh, nr, nc, p.t + 1));
					yet--;
					if(yet == 0)
						answer = p.t + 1;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
