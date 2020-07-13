package 프로그래머스;

public class 하샤드_수 {

	public static void main(String[] args) {
		int x = 13;
		System.out.println(solution(x));
	}
	
	public static boolean solution(int x) {
		boolean answer = true;
		int sum = 0;
		String s = "" + x;
		for(int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		answer = x % sum == 0 ? true : false;
		return answer;
	}
}
