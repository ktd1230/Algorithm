package 라인;

public class Solution4 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static int solution(int[][] maze) {
		int answer = 0;
		int d = 0;
		int H = maze.length;
		int W = maze.length;
		int r = 0;
		int c = 0;
        int[] dr = { 0, 1, 0, -1 };
	    int[] dc = { 1, 0, -1, 0 };
		while (!(r == H - 1 && c == W - 1)) {
			answer++;
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			while (nr < 0 || nc < 0 || nr >= H || nc >= W || maze[nr][nc] == 1) {
				d = (d + 1) % 4;
				nr = r + dr[d];
				nc = c + dc[d];
			}
			r = nr;
			c = nc;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] map1 = new int[][] { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		int[][] map2 = new int[][] { { 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0 } };
		int[][] map3 = new int[][] { { 0, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 } };
		int[][] map4 = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0 } };
		System.out.println(solution(map1));
		System.out.println(solution(map2));
		System.out.println(solution(map3));
		System.out.println(solution(map4));
	}
}