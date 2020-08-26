package 프로그래머스;

public class 다음_큰_숫자 {

	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int answer = 0;
		String bin = Integer.toBinaryString(n);
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < bin.length(); i++) {
			cnt1 = bin.charAt(i) == '1' ? ++cnt1 : cnt1;
		}
		answer = n;
		while(cnt1 != cnt2) {
			answer++;
			cnt2 = 0;
			String newBin = Integer.toBinaryString(answer);
			for (int i = 0; i < newBin.length(); i++) {
				cnt2 = newBin.charAt(i) == '1' ? ++cnt2 : cnt2;
			}
		}
		return answer;
	}
}
