package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 컵라면 {

	static class Prob implements Comparable<Prob> {
		int deadline;
		int ram;

		Prob(int deadline, int ram) {
			this.deadline = deadline;
			this.ram = ram;
		}

		public int compareTo(Prob p) {
			if (p.deadline == deadline)
				return p.ram - ram;
			return p.deadline - deadline;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		PriorityQueue<Prob> que = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			que.add(new Prob(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		PriorityQueue<Prob> res = new PriorityQueue<>(new Comparator<Prob>() {
			public int compare(Prob p1, Prob p2) {
				return p2.ram - p1.ram;
			}
		});
		int answer = 0;
		for (int i = N; i > 0; i--) {
			while (!que.isEmpty()) {
				if (i > que.peek().deadline)
					break;
				if (i <= que.peek().deadline)
					res.add(que.poll());
			}
			if (res.isEmpty())
				continue;
			answer += res.poll().ram;
		}
		System.out.println(answer);
	}

}
