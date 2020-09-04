package 안랩;

public class Solution2 {
	public static void main(String[] args) {
		String block = ">><";
		int pos = 1;
		System.out.println(solution(">><>>", 2));
	}

	public static long solution(String block, int pos) {
		long answer = 0;
		char[] map = block.toCharArray();
		pos--;

		while (true) {
			int n = pos;
			answer++;
			if (map[pos] == '<') {
				pos--;
				if (pos < 0) {
					break;
				}
				map[n] = '>';
			} else {
				pos++;
				if (pos >= map.length) {
					break;
				}
				map[n] = '<';
			}
		}

		return answer;
	}
}