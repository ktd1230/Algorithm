package 프로그래머스;

import java.util.Arrays;
import java.util.*;

public class 카카오프렌즈_컬러링북 {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}
	
	public static class Pos{
		int r;
		int c;
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j] && picture[i][j] != 0) {
					int size = 0;
					numberOfArea++;
					visited[i][j] = true;
					que.add(new Pos(i, j));
					size++;
					while(!que.isEmpty()) {
						Pos p = que.poll();
						for (int k = 0; k < 4; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= m || nc >= n)
								continue;
							else if(!visited[nr][nc] && picture[p.r][p.c] == picture[nr][nc]) {
								visited[nr][nc] = true;
								que.add(new Pos(nr, nc));
								size++;
							}
						}
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}
