package 프로그래머스;

public class JadenCase_문자열_만들기 {
	
	public static void main(String[] args) {
		String s = "3people unFollowed me";
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		String answer = "";
		String[] tmp = s.split(" ");
		boolean check = true;
		for (int i = 0; i < s.length(); i++) {
			if(check) {
				answer += s.substring(i, i + 1).toUpperCase();
				check = false;
			}
			else if(s.charAt(i) == ' ') {
				answer += s.charAt(i);
				check = true;
			}
			else {
				answer += s.substring(i, i + 1).toLowerCase();
			}
		}
		return answer;
	}

}
