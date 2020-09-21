package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_붙이기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] colorPaper = { 0, 0, 0, 0, 0 };
		dfs(paper, colorPaper);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static int min = Integer.MAX_VALUE;
	public static void dfs(int[][] paper, int[] colorPaper) {
		boolean check = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(paper[i][j] == 1)
					check = false;
			}
		}
		if(check) {
			int cnt = 0;
			for (int i = 0; i < colorPaper.length; i++) {
				cnt += colorPaper[i];
			}
			min = Math.min(min, cnt);
			return;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(paper[i][j] == 1) {
					for (int j2 = 4; j2 >= 0; j2--) {
						if(colorPaper[j2] >= 5)
							continue;
						int maxR = i + j2;
						int maxC = j + j2;
						if(maxR >= 10 || maxC >= 10)
							continue;
						boolean isRight = true;
						for (int k = 0; k <= j2; k++) {
							for (int k2 = 0; k2 <= j2; k2++) {
								if(paper[i + k][j + k2] == 0) {
									isRight = false;
									break;
								}
							}
							if(!isRight)
								break;
						}
						if(!isRight)
							continue;
						for (int k = 0; k <= j2; k++) {
							for (int k2 = 0; k2 <= j2; k2++) {
								paper[i + k][j + k2] = 0;
							}
						}
						colorPaper[j2]++;
						dfs(paper, colorPaper);
						colorPaper[j2]--;
						for (int k = 0; k <= j2; k++) {
							for (int k2 = 0; k2 <= j2; k2++) {
								paper[i + k][j + k2] = 1;
							}
						}
					}
					if(paper[i][j] == 1)
						return;
				}
			}
		}
		
	}

}
