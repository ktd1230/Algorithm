package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = new String[2];
		str[0] = br.readLine();
		str[1] = br.readLine();
		
		int max = 0;
		for (int k = 0; k < str[0].length(); k++) {
			int cnt = 0;
			boolean[] visited = new boolean[str[0].length()];
			for (int i = k; i < str[0].length() - str[1].length() + 1; i++) {
				boolean flag = true;
				for (int j = 0; j < str[1].length(); j++) {
					if(visited[i + j] || str[0].charAt(i + j) != str[1].charAt(j))
						flag = false;
				}
				if(flag) {
					cnt++;
					visited[i + str[1].length() - 1] = true;
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}
	
}