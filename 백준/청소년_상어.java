package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 청소년_상어 {
	static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int d;
		int num;

		Fish(int r, int c, int d, int num) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.num = num;
		}

		@Override
		public int compareTo(Fish o) {
			// TODO Auto-generated method stub
			return num - o.num;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", d=" + d + ", num=" + num + "]";
		}

	}

	
	// 방향은 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상 순으로 0번부터 반시계 순으로 정한다.
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] map = new int[4][4];
		ArrayList<Fish> fishes = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = num;
				// 각각의 물고기를 리스트에 저장한다.
				fishes.add(new Fish(i, j, dir, num));
			}
		}

		// 처음에 상어가 0, 0 위치에 온다. 방향은 0, 0 위치에 있던 물고기의 방향이 상어의 방향이 된다.
		int Sr = fishes.get(0).r;
		int Sc = fishes.get(0).c;
		int Sd = fishes.get(0).d;
		int sum = map[Sr][Sc];
		map[Sr][Sc] = -1;
		fishes.remove(0);

		// 물고기를 번호 순서대로 정렬한다.
		Collections.sort(fishes);

		dfs(map, fishes, Sr, Sc, Sd, sum);
		System.out.println(max);
	}

	static int max;

	public static void dfs(int[][] map, ArrayList<Fish> fishes, int Sr, int Sc, int Sd, int sum) {
		max = Math.max(max, sum);
		int[][] newMap = new int[4][4];
		ArrayList<Fish> newFishes = new ArrayList<>();
		for (Fish fish : fishes) {
			newFishes.add(new Fish(fish.r, fish.c, fish.d, fish.num));
		}
		for (int i = 0; i < newMap.length; i++) {
			System.arraycopy(map[i], 0, newMap[i], 0, 4);
		}
		// 물고기가 먼저 번호 순서대로 이동한다. 물고기는 해당 방향으로 한 칸씩만 이동할 수 있고 그 방향이 비어있거나 다른 물고기가 있으면 위치를
		// 스왑한다.
		// 그 방향에 상어가 있거나 막다른 길이라 이동하지 못한다면 방향을 45도 반시계 회전시킨다. 결국에도 이동할 수 없으면 이동하지 않는다.
		for (int i = 0; i < newFishes.size(); i++) {
			Collections.sort(newFishes);

			Fish f = newFishes.get(i);
			for (int j = 0; j < 8; j++) {
				int nd = (f.d + j) % 8;

				int nr = f.r + dr[nd];
				int nc = f.c + dc[nd];
				if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4)
					continue;
				else if (newMap[nr][nc] != -1) {
					Fish nf = null;
					for (int k = 0; k < newFishes.size(); k++) {
						if (newFishes.get(k).num == newMap[nr][nc]) {
							nf = newFishes.get(k);
							break;
						}
					}
					int tmp = 0;
					tmp = newMap[f.r][f.c];
					newMap[f.r][f.c] = newMap[nr][nc];
					newMap[nr][nc] = tmp;
					if (nf != null) {
						tmp = f.num;
						f.num = nf.num;
						nf.num = tmp;
						f.d = nf.d;
						nf.d = nd;
					}
					else {
						f.d = nd;
						f.r = nr;
						f.c = nc;
					}
					break;
				}
			}
		}

		// 상어가 해당 방향으로 이동하는 데 이때, 여러 경우의 수가 있다. 상어가 이동하면 방향은 그 위치에 있던 물고기의 방향이 되고 그 해당
		// 물고기의 번호가 결과 점수에 추가된다.
		// 상어가 먹을 수 있는 물고기 번호의 합의 최댓값을 구해보자.
		for (int i = 1; i <= 4; i++) {
			int nSr = Sr + dr[Sd] * i;
			int nSc = Sc + dc[Sd] * i;
			if(nSr < 0 || nSc < 0 || nSr >= 4 || nSc >= 4)
				continue;
			else if(newMap[nSr][nSc] == 0)
				continue;
			int nSd = 0;
			Fish f = null;
			int idx = 0;
			for (int j = 0; j < newFishes.size(); j++) {
				if (newFishes.get(j).num == newMap[nSr][nSc]) {
					f = newFishes.get(j);
					idx = j;
					break;
				}
			}
			nSd = f.d;
			int num = newMap[nSr][nSc];
			int nSum = sum + num;

			newFishes.remove(idx);
			newMap[nSr][nSc] = -1;
			newMap[Sr][Sc] = 0;
			dfs(newMap, newFishes, nSr, nSc, nSd, nSum);
			newFishes.add(idx, f);
			newMap[nSr][nSc] = num;
			newMap[Sr][Sc] = -1;
		}
	}
}
