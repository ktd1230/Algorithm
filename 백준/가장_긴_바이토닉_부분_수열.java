package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_바이토닉_부분_수열 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[2][N];
		
		for (int i = 0; i < N; i++) {
			dp[0][i] = 1;
			for (int j = 0; j < N; j++) {
				if(arr[i] > arr[j] && dp[0][i] <= dp[0][j])
					dp[0][i] = dp[0][j] + 1;
			}
		}
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			dp[1][i] = 1;
			for (int j = N - 1; j >= 0; j--) {
				if(arr[i] > arr[j] && dp[1][i] <= dp[1][j])
					dp[1][i] = dp[1][j] + 1;
			}
			max = Math.max(max, dp[0][i] + dp[1][i] - 1);
		}
		System.out.println(max);
	}

}
