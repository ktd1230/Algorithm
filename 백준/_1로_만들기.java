package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로_만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			int a = Integer.MAX_VALUE;
			if (i % 3 == 0)
				a = Math.min(a, memo[i / 3] + 1);
			if (i % 2 == 0)
				a = Math.min(a, memo[i / 2] + 1);
			
				a = Math.min(a, memo[i - 1] + 1);
				memo[i] = a;
		}
		System.out.println(memo[N]);
	}
}
