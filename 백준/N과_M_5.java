package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_5 {

	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0, new int[M], new boolean[N], sb);
		System.out.println(sb.toString());
	}
	
	public static void perm(int r, int[] sel, boolean[] visited, StringBuilder sb) {
		if(r == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			sel[r] = arr[i];
			perm(r + 1, sel, visited, sb);
			visited[i] = false;
		}
	}
	
}
