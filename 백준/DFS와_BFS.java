package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와_BFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - 1;
		boolean[][] adj = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adj[a][b] = true;
			adj[b][a] = true;
		}
		dfs(adj, new boolean[N], N, V);
		System.out.println();
		bfs(adj, N, V);
	}

	public static void dfs(boolean[][] adj, boolean[] visited, int N, int V) {
		visited[V] = true;
		System.out.print(V + 1 + " ");
		for (int i = 0; i < N; i++) {
			if (adj[V][i] && !visited[i])
				dfs(adj, visited, N, i);
		}
	}

	public static void bfs(boolean[][] adj, int N, int V) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N];
		visited[V] = true;
		que.add(V);
		while (!que.isEmpty()) {
			int v = que.poll();
			System.out.print(v + 1 + " ");
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adj[v][i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
	}

}
