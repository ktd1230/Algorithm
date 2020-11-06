package 백준;

import java.util.Scanner;

public class 파도반_수열 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[100];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		for (int i = 5; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			System.out.println(dp[N - 1]);
		}
	}

}
