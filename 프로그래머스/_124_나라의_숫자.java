package 프로그래머스;

public class _124_나라의_숫자 {

	public static void main(String[] args) {
		int n = 13;
		System.out.println(solution(n));
	}
	
	public static String solution(int n) {
		String answer = "";
		int p = 1;
		while(n > 0) {
			p *= 3;
			int num = n % p;
			int d = p / 3;
			if(num != 0 && num <= d)
				answer = '1' + answer;
			else if(num != 0 && num <= 2 * d)
				answer = '2' + answer;
			else if(num == 0 || num <= 3 * d)
				answer = '4' + answer;
			n -= p;
		}
		
		return answer;
	}
	
}
