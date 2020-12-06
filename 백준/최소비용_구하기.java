package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용_구하기 {

	static class Edge implements Comparable<Edge>{
		int v;
		int w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return w - o.w;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Edge(end, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;

		int[] dist = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(dist, 987654321);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		for (int i = 0; i < adj[start].size(); i++) {
			if (dist[adj[start].get(i).v] > adj[start].get(i).w) {
				dist[adj[start].get(i).v] = adj[start].get(i).w;
				pq.add(new Edge(adj[start].get(i).v, dist[adj[start].get(i).v]));
			}
		}
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.v])
				continue;
			for (int i = 0; i < adj[e.v].size(); i++) {
				if(dist[adj[e.v].get(i).v] > dist[e.v] + adj[e.v].get(i).w) {
					dist[adj[e.v].get(i).v] = dist[e.v] + adj[e.v].get(i).w;
					pq.add(new Edge(adj[e.v].get(i).v, dist[adj[e.v].get(i).v]));
				}
			}
			visited[e.v] = true;
		}
		System.out.println(dist[end]);
	}

}
