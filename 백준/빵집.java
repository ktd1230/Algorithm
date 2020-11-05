package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			check = false;
			dfs(map, R, C, i, 0);
			
		}
		System.out.println(answer);
	}
	
	static int[] dr = { -1, 0, 1 };
	static int[] dc = {  1, 1, 1 };
	static boolean check;
	static int answer;
	public static void dfs(char[][] map, int R, int C, int r, int c) {
		if(check)
			return;
		if( c == C - 1 ) {
			check = true;
			answer++;
			return;
		}
		map[r][c] = 'x';
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= R || nc >= C)
				continue;
			else if(map[nr][nc] == '.')
				dfs(map, R, C, nr, nc);
		}
	}

}
