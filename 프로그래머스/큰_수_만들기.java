package 프로그래머스;

public class 큰_수_만들기 {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		char max = 0;
		int maxIdx = 0;
		for (int i = 0; i < number.length(); i++) {
			if(i == k + sb.length() + 1) {
				sb.append(max);
				max = 0;
				i = maxIdx + 1;
			}
			if(max < number.charAt(i)) {
				max = number.charAt(i);
				maxIdx = i;
			}
		}
		sb.append(max);
		answer = sb.toString();
		return answer;
	}

}
