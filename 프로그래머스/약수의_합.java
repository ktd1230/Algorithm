package 프로그래머스;

public class 약수의_합 {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if(n % i == 0)
				answer += i;
		}
		return answer;
	}
}
