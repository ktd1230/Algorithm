package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_6 {
	
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		comb(0, 0, new int[M], sb);
		System.out.println(sb.toString());
	}
	
	public static void comb(int idx, int r, int[] sel, StringBuilder sb) {
		if(r == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < N; i++) {
			sel[r] = arr[i];
			comb(i + 1, r + 1, sel, sb);
		}
	}

}
