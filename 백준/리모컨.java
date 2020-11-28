package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int page = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] broken = new int[n];
		if (n > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				broken[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solution(page, broken));
	}

	public static int solution(int page, int[] broken) {
		boolean[] check = new boolean[10];
		for (int i = 0; i < broken.length; i++) {
			check[broken[i]] = true;
		}
		int ans = 987654321;
		int idx1 = page;
		int idx2 = page;
		while (broken.length != 10) { // 페이지 부터 양쪽으로 나아가면서 리모컨으로 누를 수 있는 페이지 탐색
			int num = idx1;
			boolean isOk1 = true;
			int cnt1 = 0;
			while (num >= 0) {
				cnt1++;
				if (check[num % 10])
					isOk1 = false;
				num /= 10;
				if (num == 0)
					break;
			}
			num = idx2;
			boolean isOk2 = true;
			int cnt2 = 0;
			while (num >= 0) {
				cnt2++;
				if (check[num % 10])
					isOk2 = false;
				num /= 10;
				if (num == 0)
					break;
			}
			if (isOk1) {
				ans = Math.min(ans, cnt1 + idx1 - page);
			}
			if (isOk2 && idx2 >= 0) {
				ans = Math.min(ans, cnt2 + page - idx2);
			}
			if (isOk1 || (isOk2 && idx2 >= 0))
				break;
			idx1++;
			idx2--;
		}

		ans = page > 100 ? Math.min(ans, page - 100) : Math.min(ans, 100 - page);
		return ans;
	}

}
