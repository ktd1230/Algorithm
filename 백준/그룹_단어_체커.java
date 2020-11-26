package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 그룹_단어_체커 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			Map<Character, Boolean> map = new HashMap<>();
			map.put(s.charAt(0), true);
			boolean check = true;
			for(int j = 1; j < s.length(); j++) {
				if(s.charAt(j - 1) != s.charAt(j) && map.get(s.charAt(j)) != null)
					check = false;
				map.put(s.charAt(j), true);
			}
			if(check)
				cnt++;
		}
		System.out.println(cnt);
	}

}
