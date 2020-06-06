package 백준;

import java.util.Scanner;
import java.util.Stack;

public class 유기농_배추 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[N][M];
			int cnt = 0;
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				map[n][m] = 1;
			}

			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						stack.push(i);
						stack.push(j);
						while (!stack.isEmpty()) {
							int y = stack.pop();
							int x = stack.pop();
							visited[x][y] = true;
							if (x - 1 >= 0 && !visited[x - 1][y] && map[x - 1][y] == 1) {
								stack.push(x - 1);
								stack.push(y);
							}
							if (x + 1 < N && !visited[x + 1][y] && map[x + 1][y] == 1) {
								stack.push(x + 1);
								stack.push(y);
							}
							if (y - 1 >= 0 && !visited[x][y - 1] && map[x][y - 1] == 1) {
								stack.push(x);
								stack.push(y - 1);
							}
							if (y + 1 < M && !visited[x][y + 1] && map[x][y + 1] == 1) {
								stack.push(x);
								stack.push(y + 1);
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}