package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어_벨트_위의_로봇 {

	static class Pos {
		int k;
		boolean isHere;

		Pos(int k, boolean isHere) {
			this.k = k;
			this.isHere = isHere;
		}

		@Override
		public String toString() {
			return "Pos [k=" + k + ", isHere=" + isHere + "]";
		}

	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Pos[][] belt = new Pos[2][N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			belt[0][i] = new Pos(Integer.parseInt(st.nextToken()), false);
		}

		for (int i = N - 1; i >= 0; i--) {
			belt[1][i] = new Pos(Integer.parseInt(st.nextToken()), false);
		}

		int time = 0;
		while (K > 0) {
			Pos p = belt[0][0];
			int r = 0;
			int c = 0;
			int d = 0;
			for (int i = 0; i < 2 * N; i++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= 2 || nc >= N) {
					nr -= dr[d];
					nc -= dc[d];
					d++;
					nr += dr[d];
					nc += dc[d];
				}
				belt[r][c] = belt[nr][nc];
				r = nr;
				c = nc;
			}
			belt[r - dr[d]][c - dc[d]] = p;
			
			belt[0][N - 1].isHere = false;

			for (int i = N - 1; i >= 0; i--) {
				if (belt[0][i].isHere) {
					if (i + 1 < N && (belt[0][i + 1].k == 0 || belt[0][i + 1].isHere))
						continue;
					else if (i + 1 < N && belt[0][i + 1].k > 0 && !belt[0][i + 1].isHere) {
						belt[0][i + 1].isHere = true;
						belt[0][i + 1].k--;
						belt[0][i].isHere = false;
						if (belt[0][i + 1].k == 0)
							K--;
					}
				}
			}
			if (belt[0][0].k > 0) {
				belt[0][0].k--;
				belt[0][0].isHere = true;
				if (belt[0][0].k == 0)
					K--;
			}
			belt[0][N - 1].isHere = false;
			time++;
			
		}
		System.out.println(time);
	}

}
