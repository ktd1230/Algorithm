package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 과제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] homeworks = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			homeworks[i][0] = Integer.parseInt(st.nextToken());
			homeworks[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(homeworks, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o2[0] - o1[0];
				return o2[1] - o1[1];
			}
		});
		int grade = 0;
		for (int i = N; i >= 1; i--) {
			for (int j = 0; j < N; j++) {
				if (homeworks[j][0] >= i) {
					grade += homeworks[j][1];
					homeworks[j][0] = 0;
					break;
				}
			}
		}
		System.out.println(grade);
	}

}
