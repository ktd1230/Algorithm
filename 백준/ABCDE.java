package 백준;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class ABCDE {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] friend = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			friend[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a].add(b);
			friend[b].add(a);
		}
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if(ans == 1)
				break;
			visited[i] = true;
			dfs(friend, N, i, 1, visited);
			visited[i] = false;
		}
		
		System.out.println(ans);
	}
	
	static int ans;
	public static void dfs(ArrayList<Integer>[] friend, int N, int r, int cnt, boolean[] visited) {
		if(ans == 1)
			return;
		if(cnt >= 5) {
			ans = 1;
			return;
		}
		
		for (int i = 0; i < friend[r].size(); i++) {
			if(!visited[friend[r].get(i)]) {
				visited[friend[r].get(i)] = true;
				dfs(friend, N, friend[r].get(i), cnt + 1, visited);
				visited[friend[r].get(i)] = false;
			}
		}
		
	}

}
