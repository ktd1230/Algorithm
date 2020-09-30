package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리_만들기_2 {
	
	static class Pos{
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
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					num++;
					visited[i][j] = true;
					map[i][j] = num;
					que.add(new Pos(i, j));
					while(!que.isEmpty()) {
						Pos p = que.poll();
						for (int k = 0; k < 4; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(nr < 0 || nc < 0 || nr >= N || nc >= M)
								continue;
							else if(!visited[nr][nc] && map[nr][nc] == 1) {
								visited[nr][nc] = true;
								map[nr][nc] = num;
								que.add(new Pos(nr, nc));
							}
						}
					}
				}
			}
		}
		
		int[][] adj = new int[num + 1][num + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					for (int j2 = 0; j2 < 4; j2++) {
						int nr = i;
						int nc = j;
						int len = 0;
						boolean isOut = false;
						while(true) {
							nr += dr[j2];
							nc += dc[j2];
							len++;
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								isOut = true;
								break;
							}
							if(map[nr][nc] != 0)
								break;
						}
						if(len > 2 && !isOut && map[nr][nc] != 0 && map[nr][nc] != map[i][j]) {
							// 간선추가
							adj[map[i][j]][map[nr][nc]] = adj[map[i][j]][map[nr][nc]] == 0 ? len - 1 : Math.min(adj[map[i][j]][map[nr][nc]], len - 1);
						}
					}
				}
			}
		}
		
		List<Integer> nodeList = new ArrayList<>();
		boolean[] visitedNode = new boolean[num + 1];
		visitedNode[1] = true;
		nodeList.add(1);
		boolean isOk = true;
		int answer = 0;
		for (int i = 1; i < num; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int node : nodeList) {
				for (int j = 1; j <= num; j++) {
					if(!visitedNode[j] && adj[node][j] != 0 && adj[node][j] < min && adj[node][j] > 1) {
						min = adj[node][j];
						idx = j;
					}
				}
			}
			if(min == Integer.MAX_VALUE) {
				isOk = false;
				break;
			}
			answer += min;
			nodeList.add(idx);
			visitedNode[idx] = true;
		}
		if(isOk)
			System.out.println(answer);
		else
			System.out.println(-1);
	}

}
