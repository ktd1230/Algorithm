package 프로그래머스;

public class 정수_제곱근_판별 {
	public static void main(String[] args) {
		long n = 3;
		System.out.println(solution(n));
	}
	
	public static long solution(long n) {
		long answer = 0;
		for (long i = 1; i <= 7071068; i++) {
			if(n == i * i) {
				answer = (i + 1) * (i + 1);
				break;
			}
		}
		if(answer == 0)
			answer = -1;
		return answer;
	}
}
