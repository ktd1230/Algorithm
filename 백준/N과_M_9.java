package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class N과_M_9 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Set<String> set = new HashSet<>();
		comb(arr, 0, new int[M], 0, new boolean[N], set);
		Iterator<String> iter = set.iterator();
		String[] res = new String[set.size()];
		
		for (int i = 0; i < res.length; i++) {
			res[i] = iter.next();
		}
		
		Arrays.sort(res);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	public static void comb(int[] arr, int idx, int[] sel, int r, boolean[] used, Set<String> set) {
		if(r == sel.length) {
			String s = "";
			for (int i = 0; i < sel.length; i++) {
				s += sel[i] + " ";
			}
			set.add(s);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(used[i])
				continue;
			used[i] = true;
			sel[r] = arr[i];
			comb(arr, idx + 1, sel, r + 1, used, set);
			used[i] = false;
		}
	}

}
