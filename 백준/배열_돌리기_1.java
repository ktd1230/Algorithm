package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열_돌리기_1 {
	
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			rotate(N - i, M - i, i, R);
		}
		
		for (int k = 0; k < N; k++) {
			for (int k2 = 0; k2 < M; k2++) {
				System.out.print(arr[k][k2] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void rotate(int N, int M, int i, int R) {
		int time = R % (2 * (N - i) + 2 * (M - i) - 4);
		for (int j = 0; j < time; j++) {
			int d = 0;
			int r = i;
			int c = i;
			int tmp = arr[r][c];
			for (int j2 = 0; j2 < 2 * (N - i) + 2 * (M - i) - 4; j2++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < i || nc < i || nr >= N || nc >= M) {
					d++;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				arr[r][c] = arr[nr][nc];
				r = nr;
				c = nc;
			}
			arr[r - dr[d]][c - dc[d]] = tmp;
		}
	}

}
