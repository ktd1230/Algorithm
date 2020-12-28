package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_2차원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		Queue<Integer> que = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		int count = 0;
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					que.add(i);
					que.add(j);
					visited[i][j] = true;
					count++;
				}
			}
		}
		int idx = 0;
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			if (list.isEmpty() || list.get(idx - 1) == 0) {
				cnt++;
				idx++;
				list.add(count);
				count = 0;
			}
			if (!list.isEmpty()) {
				int n = list.get(idx - 1);
				list.remove(idx - 1);
				list.add(idx - 1, n - 1);
			}
			arr[x][y] = 1;
			boolean flag = false;
			for (int k = 0; k < 4; k++) {
				int nx = x + dc[k];
				int ny = y + dr[k];


				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (!visited[nx][ny] && arr[nx][ny] == 0) {
					count++;
					visited[nx][ny] = true;
					que.add(nx);
					que.add(ny);
					flag = true;
				}
			}
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		if (flag)
			System.out.println(-1);
		else
			System.out.println(cnt - 1);
	}

}
