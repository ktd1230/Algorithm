package 백준;

import java.util.Scanner;

public class 쉬운_계단_수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[10][N];
		for (int i = 1; i < 10; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j < N; j++) {
			for (int i = 0; i < 10; i++) {
				dp[i][j] = ((i - 1 < 0 ? 0 : dp[i - 1][j - 1]) + (i + 1 >= 10 ? 0 : dp[i + 1][j - 1])) % 1000000000;
			}
		}
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[i][N - 1]) % 1000000000;
		}
		System.out.println(answer);
	}

}
