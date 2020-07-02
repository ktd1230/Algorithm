package 프로그래머스;

public class 콜라츠_추측 {
	public static void main(String[] args) {
		int num = 626331;
		System.out.println(solution(num));
	}
	
	public static int solution(int num) {
		int answer = 0;
		long tmp = num;
		for (answer = 0; answer < 500; answer++) {
			if(tmp == 1)
				break;
			if(tmp % 2 == 0) {
				tmp /= 2;
			}
			else {
				tmp *= 3;
				tmp += 1;
			}
		}
		answer = answer == 500 ? -1 : answer;
		return answer;
	}
}
