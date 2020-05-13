package 프로그래머스;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		solution(priorities, location);
	}
	static class Paper{
		int priorities;
		int index;
		Paper(int priorities, int index){
			this.priorities = priorities;
			this.index = index;
		}
	}
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Paper> printer = new LinkedList<>();
		
		for (int i = 0; i < priorities.length; i++) {
			printer.add(new Paper(priorities[i], i));
		}
		Arrays.sort(priorities);
		int idx = priorities.length - 1;
		while(!printer.isEmpty()) {
			Paper p = printer.poll();
			answer++;
			if(priorities[idx] > p.priorities) {
				answer--;
				printer.add(p);
				continue;
			}
			else if(priorities[idx] == p.priorities)
				idx--;
			
			if(p.index == location)
				break;
			
		}
		return answer;
    }

}
