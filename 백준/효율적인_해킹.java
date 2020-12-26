package 백준;

import java.util.ArrayList;
import java.util.Scanner;

public class 효율적인_해킹 {

	static int N;
	static ArrayList<Integer>[] adj;
	static int[] cnt_arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		adj = new ArrayList[N + 1];
		cnt_arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[b].add(a);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dfs(i, i, new boolean[N + 1]);
			max = Math.max(max, s_max);
			cnt = 0;
			s_max = 0;
		}
		
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if(max == cnt_arr[i])
				sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

	static int s_max;
	static int cnt;
	static void dfs(int r, int n, boolean[] visited) {
		visited[r] = true;
		cnt++;
		if( s_max <= cnt ) {
			s_max = cnt;
			cnt_arr[n] = s_max;
		}
		for (int i = 0; i < adj[r].size(); i++) {

			if(!visited[adj[r].get(i)]) {
				dfs(adj[r].get(i), n, visited);
			}
		}
	}
}
