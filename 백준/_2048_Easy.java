package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2048_Easy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(board, N, 0);
		System.out.println(max);
	}
	static int max;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static void dfs(int[][] board, int N, int cnt) {
		if(cnt >= 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, board[i][j]);
				}
			}
			return;
		}
		
		for (int r = 0; r < 4; r++) {
			int[][] newBoard = new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(board[i], 0, newBoard[i], 0, N);
			}
			boolean[][] merged = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int nr = 0;
					int nc = 0;
					if(newBoard[i][j] != 0 && r == 0) { // 위로 갈 때
						nr = i + dr[r];
						nc = j + dc[r];
						boolean check = false;
						while(!isOut(N, r, nr, nc) && newBoard[nr][nc] == 0) {
							nr += dr[r];
							nc += dc[r];
							check = true;
						}

						if(!isOut(N, r, nr, nc) && !merged[nr][nc] && newBoard[nr][nc] == newBoard[i][j]) {
							newBoard[nr][nc] += newBoard[i][j];
							newBoard[i][j] = 0;
							merged[nr][nc] = true;
						}
						else if(check) {
							newBoard[nr - dr[r]][nc - dc[r]] = newBoard[i][j];
							newBoard[i][j] = 0;
						}
					}
					else if(newBoard[N - 1 - i][j] != 0 && r == 1) { // 아래로 갈 때
						nr = N - 1 - i + dr[r];
						nc = j + dc[r];
						boolean check = false;
						while(!isOut(N, r, nr, nc) && newBoard[nr][nc] == 0) {
							nr += dr[r];
							nc += dc[r];
							check = true;
						}
						if(!isOut(N, r, nr, nc) && !merged[nr][nc] && newBoard[nr][nc] == newBoard[N - 1 - i][j]) {
							newBoard[nr][nc] += newBoard[N - 1 - i][j];
							newBoard[N - 1 - i][j] = 0;
							merged[nr][nc] = true;
						}
						else if(check) {
							newBoard[nr - dr[r]][nc - dc[r]] = newBoard[N - 1 - i][j];
							newBoard[N - 1 - i][j] = 0;
						}
					}
					else if(newBoard[j][i] != 0 && r == 2) { // 왼쪽으로 갈 때
						nr = j + dr[r];
						nc = i + dc[r];
						boolean check = false;
						while(!isOut(N, r, nr, nc) && newBoard[nr][nc] == 0) {
							nr += dr[r];
							nc += dc[r];
							check = true;
						}
						if(!isOut(N, r, nr, nc) && !merged[nr][nc] && newBoard[nr][nc] == newBoard[j][i]) {
							newBoard[nr][nc] += newBoard[j][i];
							newBoard[j][i] = 0;
							merged[nr][nc] = true;
						}
						else if(check) {
							newBoard[nr - dr[r]][nc - dc[r]] = newBoard[j][i];
							newBoard[j][i] = 0;
						}
					}
					else if(newBoard[j][N - 1 - i] != 0 && r == 3) { // 오른쪽으로 갈 때
						nr = j + dr[r];
						nc = N - 1 - i + dc[r];
						boolean check = false;
						while(!isOut(N, r, nr, nc) && newBoard[nr][nc] == 0) {
							nr += dr[r];
							nc += dc[r];
							check = true;
						}
						if(!isOut(N, r, nr, nc) && !merged[nr][nc] && newBoard[nr][nc] == newBoard[j][N - 1 - i]) {
							newBoard[nr][nc] += newBoard[j][N - 1 - i];
							newBoard[j][N - 1 - i] = 0;
							merged[nr][nc] = true;
						}
						else if(check) {
							newBoard[nr - dr[r]][nc - dc[r]] = newBoard[j][N - 1 - i];
							newBoard[j][N - 1 - i] = 0;
						}
					}
				}
			}
			dfs(newBoard, N, cnt + 1);
		}
			
	}
	
	static boolean isOut(int N, int r, int i, int j) {
		if(i < 0 || i >= N || j < 0 || j >= N)
			return true;
		else
			return false;
	}
}
