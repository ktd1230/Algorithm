package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 구슬_탈출_2 {

	static class Pos {
		char color;
		int r;
		int c;

		Pos(char color, int r, int c) {
			this.color = color;
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];

		ArrayList<Pos> ball = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'B' || map[i][j] == 'R')
					ball.add(new Pos(map[i][j], i, j));
			}
		}

		for (int i = 0; i < 4; i++) {
			dfs(ball, map, 1, i);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void roll(ArrayList<Pos> ball, char[][] map, int d, Pos p) {
		int nr = p.r + dr[d];
		int nc = p.c + dc[d];
		boolean isIn = true;
		boolean check = false;
		while (true) {
			if (map[nr][nc] == 'O') {
				isIn = false;
				break;
			}
			if (map[nr][nc] == '#') {
				nr -= dr[d];
				nc -= dc[d];
				break;
			}
			if (map[nr][nc] == 'R' || map[nr][nc] == 'B')
				check = true;
			nr += dr[d];
			nc += dc[d];
		}
		if (isIn) {
			if (check)
				ball.add(new Pos(p.color, nr - dr[d], nc - dc[d]));
			else
				ball.add(new Pos(p.color, nr, nc));
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min = Integer.MAX_VALUE;

	static void dfs(ArrayList<Pos> ball, char[][] map, int cnt, int d) {
		if (cnt > 10)
			return;
		ArrayList<Pos> newBall = new ArrayList<>();
		Pos p1 = ball.get(0);
		Pos p2 = ball.get(1);
		switch (d) {
		case 0:
			if (p1.r <= p2.r) {
				roll(newBall, map, d, p1);
				roll(newBall, map, d, p2);
			} else {
				roll(newBall, map, d, p2);
				roll(newBall, map, d, p1);
			}
			break;
		case 1:
			if (p1.r > p2.r) {
				roll(newBall, map, d, p1);
				roll(newBall, map, d, p2);
			} else {
				roll(newBall, map, d, p2);
				roll(newBall, map, d, p1);
			}
			break;
		case 2:
			if (p1.c <= p2.c) {
				roll(newBall, map, d, p1);
				roll(newBall, map, d, p2);
			} else {
				roll(newBall, map, d, p2);
				roll(newBall, map, d, p1);
			}
			break;
		case 3:
			if (p1.c > p2.c) {
				roll(newBall, map, d, p1);
				roll(newBall, map, d, p2);
			} else {
				roll(newBall, map, d, p2);
				roll(newBall, map, d, p1);
			}
			break;
		}

		if (newBall.isEmpty())
			return;
		if (newBall.size() == 1 && newBall.get(0).color == 'B') {
			min = Math.min(min, cnt);
			return;
		} else if (newBall.size() == 1 && newBall.get(0).color == 'R')
			return;
		for (int i = 0; i < 4; i++) {
			for (Pos p : ball) {
				map[p.r][p.c] = '.';
			}
			for (Pos p : newBall) {
				map[p.r][p.c] = p.color;
			}
//			if (cnt == 10) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.println(Arrays.toString(map[j]));
//				}
//				System.out.println();
//			}
			dfs(newBall, map, cnt + 1, i);
			for (Pos p : newBall) {
				map[p.r][p.c] = '.';
			}
			for (Pos p : ball) {
				map[p.r][p.c] = p.color;
			}
		}
	}

}
