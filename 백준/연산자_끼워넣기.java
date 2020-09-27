package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(N, 0, arr[0], arr, oper);
		System.out.println(max);
		System.out.println(min);
	}
	
	static int max = -Integer.MAX_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void dfs(int N, int cnt, int res, int[] arr, int[] oper) {
		if(cnt == N - 1) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(oper[i] > 0) {
				oper[i]--;
				int total = 0;
				switch(i) {
				case 0:
					total = res + arr[cnt + 1];
					break;
				case 1:
					total = res - arr[cnt + 1];
					break;
				case 2:
					total = res * arr[cnt + 1];
					break;
				case 3:
					total = res / arr[cnt + 1];
					break;
				}
				dfs(N, cnt + 1, total, arr, oper);
				oper[i]++;
			}
		}
	}

}
