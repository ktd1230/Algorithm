package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Puyo_Puyo {

	static class Pos {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		char[][] field = new char[12][6];
		for (int i = 0; i < 12; i++)
			field[i] = br.readLine().toCharArray();

		Queue<Pos> que = new LinkedList<>();
		boolean[][] visited = new boolean[12][6];
		boolean isPang = true;
		while (isPang) {
			ArrayList<Pos> pang = new ArrayList<>();
			isPang = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!visited[i][j] && field[i][j] != '.') {
						que.add(new Pos(i, j));
						visited[i][j] = true;
						char color = field[i][j];
						ArrayList<Pos> list = new ArrayList<>();

						while (!que.isEmpty()) {
							Pos p = que.poll();
							list.add(p);
							for (int k = 0; k < 4; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];
								if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6)
									continue;
								else if (!visited[nr][nc] && color == field[nr][nc]) {
									visited[nr][nc] = true;
									que.add(new Pos(nr, nc));
								}
							}
						}
						if (list.size() >= 4) {
							isPang = true;
							pang.addAll(list);
						}
					}
				}
			}
			for (int k = 0; k < pang.size(); k++) {
				field[pang.get(k).r][pang.get(k).c] = '.';
			}

			String[] newField = new String[6];
			for (int k = 0; k < 6; k++) {
				newField[k] = "";
				for (int k2 = 11; k2 >= 0; k2--) {
					if (field[k2][k] != '.')
						newField[k] += field[k2][k];
				}
			}
			for (int k = 0; k < 12; k++) {
				Arrays.fill(field[k], '.');
			}

			for (int k = 0; k < 6; k++) {
				for (int k2 = 0; k2 < newField[k].length(); k2++) {
					field[11 - k2][k] = newField[k].charAt(k2);
				}
			}
			visited = new boolean[12][6];
			if(isPang)
				answer++;
		}
		System.out.println(answer);

	}

}
