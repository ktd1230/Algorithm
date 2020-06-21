package 프로그래머스;

public class 소수_찾기 {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int answer = 0;
		boolean[] check = new boolean[n + 1];
		for (int i = 2; i < check.length; i++) {
			if(!check[i]) {
				answer++;
				for (int j = i; j < check.length; j+=i) {
					check[j] = true;
				}
			}
		}
		return answer;
	}
}
