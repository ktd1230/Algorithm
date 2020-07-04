package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		perm(N, new int[M], 1, 0);
	}
	
	public static void perm(int N, int[] sel, int idx, int r) {
		if(sel.length == r) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			sel[r] = i;
			perm(N, sel, i, r + 1);
		}
	}
}
