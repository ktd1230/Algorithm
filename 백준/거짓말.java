package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거짓말 {

	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());

		int s = 0;
		for (int i = 0; i < know; i++) {
			int a = 0;
			if(s == 0)
				s = Integer.parseInt(st.nextToken());
			else
				a = Integer.parseInt(st.nextToken());
			if(a != 0)
				union(s, a);
		}
		int[][] arr = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			arr[i] = new int[num];
			int a = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			for (int j = 1; j < num; j++) {
				int b = Integer.parseInt(st.nextToken());
				arr[i][j] = b;
				union(a, b);
			}
			
		}
		int ans = 0;
		for (int i = 0; i < M; i++) {
			boolean flag = false;
			for (int j = 0; j < arr[i].length; j++) {
				if(findSet(arr[i][j]) == findSet(s))
					flag = true;
			}
			if(!flag)
				ans++;
		}
		System.out.println(ans);
		
	}
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		p[py] = px;
	}
}
