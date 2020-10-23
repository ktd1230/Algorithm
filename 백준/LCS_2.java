package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] LCS = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
			}
		}

		int r = s1.length();
		int c = s2.length();
		int answer = LCS[r][c];
		StringBuilder res = new StringBuilder();
		while(r != 0 && c != 0) {
			if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
				res.append(s1.charAt(r - 1));
				r--;
				c--;
			} else {
				if (LCS[r - 1][c] > LCS[r][c - 1])
					r--;
				else
					c--;
			}
		}

		System.out.println(answer);
		System.out.println(res.reverse().toString());
	}

}
