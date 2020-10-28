package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {

	static class Pos{

		int idx;
		int time;

		Pos(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visited = new boolean[100001];
		Queue<Pos> que = new LinkedList<>();
		visited[N] = true;
		que.add(new Pos(N, 0));
		int[] dr = { -1, 1, 1 };
		int answer = 0;
		while (!que.isEmpty()) {
			Pos p = que.poll();
			if(p.idx == K) {
				answer = p.time;
				break;
			}
			for (int i = 0; i < 3; i++) {
				int nidx = i < 2 ? p.idx + dr[i] : p.idx + dr[i] * p.idx;
				if (nidx < 0 || nidx > 100000)
					continue;
				else if (!visited[nidx]) {
					visited[nidx] = true;
					que.add(new Pos(nidx, p.time + 1));
				}
			}
		}
		System.out.println(answer);
	}

}
