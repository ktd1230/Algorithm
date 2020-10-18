package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int[][][] tet = { { { 1, 1, 1, 1 } }, { { 1 }, { 1 }, { 1 }, { 1 } }, { { 1, 1 }, { 1, 1 } },
			{ { 1, 0 }, { 1, 0 }, { 1, 1 } }, { { 0, 1 }, { 0, 1 }, { 1, 1 } }, { { 1, 1 }, { 0, 1 }, { 0, 1 } },
			{ { 1, 1 }, { 1, 0 }, { 1, 0 } }, { { 0, 0, 1 }, { 1, 1, 1 } }, { { 1, 1, 1 }, { 0, 0, 1 } },
			{ { 1, 1, 1 }, { 1, 0, 0 } }, { { 1, 0, 0 }, { 1, 1, 1 } }, { { 1, 0 }, { 1, 1 }, { 0, 1 } },
			{ { 0, 1 }, { 1, 1 }, { 1, 0 } }, { { 0, 1, 1 }, { 1, 1, 0 } }, { { 1, 1, 0 }, { 0, 1, 1 } },
			{ { 1, 1, 1 }, { 0, 1, 0 } }, { { 0, 1, 0 }, { 1, 1, 1 } }, { { 1, 0 }, { 1, 1 }, { 1, 0 } },
			{ { 0, 1 }, { 1, 1 }, { 0, 1 } }, };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int j2 = 0; j2 < tet.length; j2++) {
					int sum = 0;
					boolean check = true;
					for (int k = 0; k < tet[j2].length; k++) {
						for (int k2 = 0; k2 < tet[j2][k].length; k2++) {
							if(i + k >= N || j + k2 >= M) {
								check = false;
								continue;
							}
							if(tet[j2][k][k2] == 1)
								sum += map[i + k][j + k2];
						}
					}
					if(check)
						max = Math.max(max, sum);
					
				}

			}
		}
		System.out.println(max);
	}
}
