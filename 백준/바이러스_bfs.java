package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_bfs {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[][] adj = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adj[a][b] = true;
			adj[b][a] = true;
		}
		bfs(adj, N, 0);
		System.out.println(cnt - 1);
	}
	
	static int cnt;
	public static void bfs(boolean[][] adj, int N, int V) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N];
		visited[V] = true;
		que.add(V);
		while (!que.isEmpty()) {
			int v = que.poll();
			cnt++;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adj[v][i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
	}

}
