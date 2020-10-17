package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트_택시 {

	static class Pos {
		int sR;
		int sC;
		int eR;
		int eC;
		int dis;

		Pos(int sR, int sC, int eR, int eC) {
			this.sR = sR;
			this.sC = sC;
			this.eR = eR;
			this.eC = eC;
		}

		@Override
		public String toString() {
			return "Pos [sR=" + sR + ", sC=" + sC + ", eR=" + eR + ", eC=" + eC + "]";
		}

	}

	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int F = Integer.parseInt(st.nextToken());
		int startF = F;
		int[][] map = new int[N][N];
		int[][] gmap = new int[N][N];
		ArrayList<Pos> guest = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				gmap[i][j] = -map[i][j];
			}
		}
		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken()) - 1;
		int startC = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int sR = Integer.parseInt(st.nextToken()) - 1;
			int sC = Integer.parseInt(st.nextToken()) - 1;
			int eR = Integer.parseInt(st.nextToken()) - 1;
			int eC = Integer.parseInt(st.nextToken()) - 1;
			guest.add(new Pos(sR, sC, eR, eC));
			gmap[sR][sC] = i;
		}

		int num = guest.size();
		while (F >= 0) {
			Pos nextG = null;
			Queue<Pos> que = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			que.add(new Pos(startR, startC, 0, 0));
			visited[startR][startC] = true;
			if (gmap[startR][startC] > 0) {
				nextG = guest.get(gmap[startR][startC] - 1);
				gmap[startR][startC] = 0;
				que.clear();
			}
			PriorityQueue<Pos> next = new PriorityQueue<>(new Comparator<Pos>() {
				public int compare(Pos o1, Pos o2) {
					if(o1.dis == o2.dis) {
						if(o1.sR == o2.sR)
							return o1.sC - o2.sC;
						return o1.sR - o2.sR;
					}
					return o1.dis - o2.dis;
				}
			});
			while (!que.isEmpty()) {
				Pos p = que.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p.sR + dr[i];
					int nc = p.sC + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					else if (!visited[nr][nc] && gmap[nr][nc] == 0) {
						visited[nr][nc] = true;
						que.add(new Pos(nr, nc, p.eR + 1, 0));
					} else if (!visited[nr][nc] && gmap[nr][nc] > 0) {
						visited[nr][nc] = true;
						guest.get(gmap[nr][nc] - 1).dis = p.eR + 1;
						next.add(guest.get(gmap[nr][nc] - 1));
					}
				}
			}
			if(!next.isEmpty()) {
				nextG = next.poll();
				gmap[nextG.sR][nextG.sC] = 0;
				F -= nextG.dis;
			}
			if (nextG == null)
				break;
			// 손님 운반
			que = new LinkedList<>();
			visited = new boolean[N][N];
			que.add(new Pos(nextG.sR, nextG.sC, 0, 0));
			visited[nextG.sR][nextG.sC] = true;
			while (!que.isEmpty()) {
				Pos p = que.poll();
				if (F - p.eR < 0)
					break;
				if (p.sR == nextG.eR && p.sC == nextG.eC) {
					startR = p.sR;
					startC = p.sC;
					F += p.eR;
					num--;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = p.sR + dr[i];
					int nc = p.sC + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					else if (!visited[nr][nc] && map[nr][nc] == 0) {
						visited[nr][nc] = true;
						que.add(new Pos(nr, nc, p.eR + 1, 0));
					}
				}
			}
		}
		System.out.println(num == 0 ? F : -1);
	}

}
