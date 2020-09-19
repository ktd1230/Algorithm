package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N과_M_10 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		Set<String> set = new LinkedHashSet<>();
		comb(arr, new int[M], 0, 0, set);
		Iterator<String> iter = set.iterator();
		for (int i = 0; i < set.size(); i++) {
			System.out.println(iter.next());
		}
	}
	
	public static void comb(int[] arr, int[] sel, int idx, int r, Set<String> set) {
		if(sel.length == r) {
			String s = "";
			for (int i = 0; i < sel.length; i++) {
				s += sel[i] + " ";
			}
			set.add(s);
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[r] = arr[i];
			comb(arr, sel, i + 1, r + 1, set);
		}
	}

}
