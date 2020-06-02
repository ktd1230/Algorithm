package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	static class Progress {
		int p;
		int s;
		Progress(int p, int s){
			this.p = p;
			this.s = s;
		}
		@Override
		public String toString() {
			return "Progress [p=" + p + ", s=" + s + "]";
		}
		
		
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		ArrayList<Progress> progressList = new ArrayList<Progress>();
		for (int i = 0; i < progresses.length; i++) {
			progressList.add(new Progress(progresses[i], speeds[i]));
		}
		ArrayList<Integer> list = new ArrayList<>();
		while(!progressList.isEmpty()) {
			int num = 0;
			System.out.println(progressList);
			for (Progress progress : progressList) {
				progress.p += progress.s;
			}
			for (int i = 0; i < progressList.size(); i++) {
				if(progressList.get(i).p >= 100) {
					progressList.remove(i);
					num++;
				}
				else
					break;
			}
			list.add(num);
		}
		
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
