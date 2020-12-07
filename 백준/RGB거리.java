package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] color = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N + 1][3];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
		}
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}

}
