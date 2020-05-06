package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 뱀 {

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[][] board = new boolean[N + 1][N + 1];
		char[] rotate = new char[10001];
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}

		int L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			rotate[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int d = 0;
		int time = 0;
		ArrayList<Pos> snake = new ArrayList<>();
		snake.add(new Pos(1, 1));
		out: while (true) {
			time++;
			Pos p = new Pos(snake.get(snake.size() - 1).r, snake.get(snake.size() - 1).c);
			p.r += dr[d];
			p.c += dc[d];
			for (Pos pos : snake) {
				if (p.r == pos.r && p.c == pos.c)
					break out;
			}
			if (p.r < 1 || p.c < 1 || p.r > N || p.c > N) {
				break out;
			}
			if (board[p.r][p.c])
				board[p.r][p.c] = false;
			else
				snake.remove(0);

			snake.add(p);
			switch (rotate[time]) {
			case 'L':
				d = d - 1 == -1 ? 3 : d - 1;
				break;
			case 'D':
				d = (d + 1) % 4;
				break;
			}

		}
		System.out.println(time);
	}

}