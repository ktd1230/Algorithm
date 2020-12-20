package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 조각_움직이기 {

	static class Piece {
		int r;
		int c;

		public Piece(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Piece> pieces;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[5][5];
		pieces = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == '*') {
					pieces.add(new Piece(i, j));
				}
			}
		}

		perm(0, new int[pieces.size() * 2]);
		System.out.println(min);
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	public static void perm(int r, int[] sel) {
		if (sel.length == r) {
			int dist = 0;
			int index = 0;
			int[][] newMap = new int[5][5];
			for (Piece p : pieces) {
				newMap[sel[index]][sel[index + 1]] = 1;
				dist += Math.abs(p.r - sel[index]) + Math.abs(p.c - sel[index + 1]);
				index += 2;
			}
			Queue<Piece> que = new LinkedList<>();
			boolean[][] visited = new boolean[5][5];

			int cnt = 0;
			out: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (!visited[i][j] && newMap[i][j] == 1) {
						que.add(new Piece(i, j));
						visited[i][j] = true;
						while (!que.isEmpty()) {
							Piece p = que.poll();
							cnt++;
							for (int k = 0; k < 4; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];
								if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
									continue;
								else if (!visited[nr][nc] && newMap[nr][nc] == 1) {
									visited[nr][nc] = true;
									que.add(new Piece(nr, nc));
								}
							}
						}
						break out;
					}
				}
			}

			if (cnt == pieces.size())
				min = Math.min(min, dist);
			return;
		}

		for (int i = 0; i < 5; i++) {
			sel[r] = i;
			perm(r + 1, sel);
		}

	}
}
