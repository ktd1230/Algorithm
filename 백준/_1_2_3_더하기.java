package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_2_3_더하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// 1 1
		// 2 1 1 / 2
		// 3 1 1 1 / 1 2 / 2 1 / 3
		// 4 1 1 1 1 / 1 1 2 / 1 2 1 / 2 1 1 / 2 2 / 1 3 / 3 1
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n + 3];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int j = 4; j < dp.length; j++) {
				dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}
			System.out.println(dp[n]);
		}
	}

}
