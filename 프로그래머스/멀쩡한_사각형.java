package 프로그래머스;

public class 멀쩡한_사각형 {

	public static void main(String[] args) {
		int w = 100000000;
		int h = 100000000;
		System.out.println(solution(w, h));
	}
	public static long solution(long w, long h) {
		long answer = 0;
		answer = w + h;
		for(long i = 0; i < w; i++) {
			if(h * i % w == 0) {
				answer--;
			}
		}
		answer = w * h - answer;
		return answer;
	}
}
