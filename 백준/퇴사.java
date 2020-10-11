package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] counsel = new int[N][2];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		}
		powerSet(counsel, new boolean[N], 0);
		System.out.println(max);
	}

	static int max;
	
	public static void powerSet(int[][] counsel, boolean[] check, int r) {
		if (r == counsel.length) {
			int time = 0;
			int sum = 0;
			for (int i = 0; i < counsel.length; i++) {
				if (check[i]) {
					if (time > 0)
						return;
					time = 0;
					time += counsel[i][0];
					sum += counsel[i][1];
				}
				time--;
			}
			if (time <= 0)
				max = Math.max(max, sum);
			return;
		}

		check[r] = true;
		powerSet(counsel, check, r + 1);
		check[r] = false;

		powerSet(counsel, check, r + 1);
	}

}
