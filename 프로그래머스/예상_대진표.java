package 프로그래머스;

public class 예상_대진표 {
	
	public static void main(String[] args) {
		int n = 8;
		int a = 2;
		int b = 1;
		System.out.println(solution(n, a, b));
	}

	public static int solution(int n, int a, int b) {
		int answer = 0;
		while(a != b && Math.abs(a - b) != 1) {
			a = a % 2 == 0 ? a : a + 1;
			b = b % 2 == 0 ? b : b + 1;
			a /= 2;
			b /= 2;
			answer++;
		}
		answer++;
		return answer;
	}
}
