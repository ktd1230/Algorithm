package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양 {
	
	static class Pos{
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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] field = new char[R][C];
		for (int i = 0; i < R; i++) {
			field[i] = br.readLine().toCharArray();
		}
		boolean[][] visited = new boolean[R][C];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int resOCnt = 0;
		int resVCnt = 0;
 		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j] && field[i][j] != '#') {
					int oCnt = 0;
					int vCnt = 0;
					if(field[i][j] == 'o')
						oCnt++;
					else if(field[i][j] == 'v')
						vCnt++;
					Queue<Pos> que = new LinkedList<>();
					
					visited[i][j] = true;
					que.add(new Pos(i, j));
					while(!que.isEmpty()) {
						Pos p = que.poll();
						for (int k = 0; k < 4; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= R || nc >= C)
								continue;
							else if(!visited[nr][nc] && field[nr][nc] != '#') {
								visited[nr][nc] = true;
								que.add(new Pos(nr, nc));
								if(field[nr][nc] == 'o')
									oCnt++;
								else if(field[nr][nc] == 'v')
									vCnt++;
							}
						}
					}
					if(oCnt > vCnt)
						resOCnt += oCnt;
					else
						resVCnt += vCnt;
				}
			}
		}
		System.out.println(resOCnt + " " + resVCnt);
	}

}
