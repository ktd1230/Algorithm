package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M {
	
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		perm(new int[M], 0, new boolean[N + 1]);
	}
	static void perm(int[] sel, int r, boolean[] visited) {
		if(sel.length == r) {
			for (int s : sel) {
				System.out.print(s + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			sel[r] = i;
			perm(sel, r + 1, visited);
			visited[i] = false;
		}
	}
}
