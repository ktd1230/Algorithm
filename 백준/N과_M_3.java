package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_3 {
	
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		rPerm(new int[M], 0, sb);
		
		System.out.println(sb.toString());
	}
	
	static void rPerm(int[] sel, int r, StringBuilder sb) {
		if(sel.length == r) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			sel[r] = i;
			rPerm(sel, r + 1, sb);
		}
	}
	
}