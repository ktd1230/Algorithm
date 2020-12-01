package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 전화번호_목록 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String ans = "YES";
			Map<String, Boolean> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				arr[i] = s;
				map.put(s, true);
			}
			out: for (int i = 0; i < n; i++) {
				String s = arr[i];
				for (int j = 0; j < s.length(); j++) {
					if (map.get(s.substring(0, j)) != null) {
						ans = "NO";
						break out;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
