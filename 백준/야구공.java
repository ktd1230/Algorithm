package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야구공 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] inn = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inn[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(inn, N, new int[8], 0, new boolean[8]);
		System.out.println(max);
	}

	static int max;

	public static void perm(int[][] inn, int N, int[] sel, int r, boolean[] visited) {
		if (sel.length == r) {
			int idx = 0;
			int grade = 0;

			for (int i = 0; i < N; i++) {
				int[] ground = new int[3];
				int outCnt = 0;
				while (outCnt < 3) {
					int num = (idx % 9);
					if (num == 3)
						num = 0;
					else {
						if (num > 3)
							num--;
						num = sel[num] + 1;
					}
					int type = inn[i][num];
					if (type == 0) {
						outCnt++;
					} else if (type == 4) {
						for (int j = 0; j < 3; j++) {
							if (ground[j] == 1) {
								ground[j] = 0;
								grade++;
							}
						}
						grade++;
					} else {
						for (int j = 2; j >= 0; j--) {
							if (ground[j] == 1) {
								ground[j] = 0;
								if (j + type > 2)
									grade++;
								else
									ground[j + type] = 1;
							}
						}
						ground[type - 1] = 1;
					}
					idx++;
				}
			}
			max = Math.max(max, grade);
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (visited[i])
				continue;
			sel[r] = i;
			visited[i] = true;
			perm(inn, N, sel, r + 1, visited);
			visited[i] = false;
		}
	}

}
