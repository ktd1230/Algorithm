package 프로그래머스;

public class 가운데_글자_가져오기 {

	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		String answer = "";
		answer = s.length() % 2 == 0 ? answer + s.charAt(s.length() / 2 - 1) + s.charAt(s.length() / 2) : answer + s.charAt(s.length() / 2);
		return answer;
	}
}
