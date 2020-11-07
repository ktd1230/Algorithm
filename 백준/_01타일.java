package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01타일 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 1 -> 1	 2 -> 00, 11	3 -> 001, 100, 111	4 -> 0011, 0000, 1001, 1100, 1111	5 -> 00001, 00100, 10000, 00111, 10011, 11001, 11100, 11111
		int[] dp = new int[Math.max(3, N + 1)];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}
		System.out.println(dp[N]);
		
	}
}
