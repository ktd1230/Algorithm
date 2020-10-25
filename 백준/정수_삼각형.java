package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][n];
		int answer = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = -1;
			while(st.hasMoreTokens()) {
				j++;
				int num = Integer.parseInt(st.nextToken());
				dp[i][j] += num;
				answer = Math.max(answer, dp[i][j]);
				if(i + 1 >= n)
					continue;
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
				if(j + 1 >= n)
					continue;
				dp[i + 1][j + 1] = dp[i][j];
			}
		}
		System.out.println(answer);
	}

}
