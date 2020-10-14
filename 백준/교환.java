package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 교환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		int max = -1;
		for (int l = 0; l < K; l++) {
			int size = que.size();
			boolean[] exist = new boolean[1000001];
			for (int m = 0; m < size; m++) {
				char[] arr = Integer.toString(que.poll()).toCharArray();
				for (int i = 0; i < arr.length; i++) {
					for (int j = i + 1; j < arr.length; j++) {
						char tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						if (arr[0] != '0') {
							int res = 0;
							for (int k = 0; k < arr.length; k++) {
								res *= 10;
								res += arr[k] - '0';
							}
							if (!exist[res]) {
								exist[res] = true;
								que.add(res);
							}
						}
						arr[j] = arr[i];
						arr[i] = tmp;
					}
				}
			}
		}
		while (!que.isEmpty()) {
			max = Math.max(max, que.poll());
		}
		System.out.println(max);
	}
}