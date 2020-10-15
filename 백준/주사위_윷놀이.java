package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 주사위_윷놀이 {

	static int[][] map = { { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38 },
			{ 10, 13, 16, 19 }, { 20, 22, 24 }, { 30, 28, 27, 26 }, { 25, 30, 35 }, { 40 } };

	static class Pos {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		reperm(arr, new int[10], 0);
		System.out.println(max);

	}

	static int max;

	public static void reperm(int[] arr, int[] sel, int r) {
		if (sel.length == r) {
			int score = 0;
			ArrayList<Pos> horses = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				horses.add(new Pos(0, -1));
			}
			for (int i = 0; i < 10; i++) {
				Pos p = horses.get(sel[i]);
				if (p.c >= map[p.r].length)
					return;
				int nc = p.c + arr[i];
				if (p.r == 0) { // 파란색 길을 타지 않은 최초의 길 상태 일때
					switch (nc) {
					case 4:
						nc -= 4;
						p.r = 1;
						break;
					case 9:
						nc -= 9;
						p.r = 2;
						break;
					case 14:
						nc -= 14;
						p.r = 3;
						break;
					}
				}
				if ((p.r == 1 || p.r == 2 || p.r == 3) && nc >= map[p.r].length) {
					nc -= map[p.r].length;
					p.r = 4;
				}
				if ((p.r == 4 || p.r == 0) && nc >= map[p.r].length) {
					nc -= map[p.r].length;
					p.r = 5;
				}
				if (nc >= map[p.r].length) {
					p.c = nc;
					continue;
				}
				for (int j = 0; j < 4; j++) {
					Pos pos = horses.get(j);
					if (sel[i] != j && pos.r == p.r && pos.c == nc)
						return;
				}
				p.c = nc;
				score += map[p.r][p.c];
			}
			max = Math.max(max, score);
			return;
		}

		for (int i = 0; i < 4; i++) {
			sel[r] = i;
			reperm(arr, sel, r + 1);
		}
	}

}
