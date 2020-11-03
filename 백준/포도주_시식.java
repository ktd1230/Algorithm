package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[Math.max(n, 3)];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[Math.max(n, 3)][4];
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];

		dp[1][0] = arr[0] + arr[1];
		dp[1][1] = arr[1];
		dp[1][2] = arr[0];

		for (int i = 2; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 2][2], dp[i - 2][3]) + arr[i - 1] + arr[i];
			dp[i][1] = Math.max(Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 2][2]), dp[i - 2][3]) + arr[i];
			dp[i][2] = Math.max(Math.max(dp[i - 2][1], dp[i - 2][2]), dp[i - 2][3]) + arr[i - 1];
			dp[i][3] = Math.max(Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 2][2]), dp[i - 2][3]);
		}
		System.out.println(Math.max(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]), dp[n - 1][3]));
	}

}
