package 프로그래머스;

import java.util.*;

public class 더_맵게 {
	
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++)
			minHeap.add(scoville[i]);
		
		while(!minHeap.isEmpty()) {
			int a = minHeap.poll();
			if(a >= K)
				break;
			else if(minHeap.isEmpty()) {
				answer = -1;
				break;
			}
			int b = minHeap.poll();
			minHeap.add(a + b * 2);
			answer++;
		}
		
		return answer;
	}

}
