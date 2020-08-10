package 프로그래머스;

import java.util.*;

public class 다리를_지나는_트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7,4,5,6 };
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> bridge = new LinkedList<>();
		int total = 0;
		int time = 0;
		for (int i = 0; i < truck_weights.length; i++) {
			if (i > 0 && bridge.size() == bridge_length) {
				total -= bridge.poll();
			}
			if (bridge_length >= bridge.size()) {
				if (total + truck_weights[i] <= weight) {
					bridge.add(truck_weights[i]);
					total += truck_weights[i];
				} else {
					bridge.add(0);
					i--;
				}
			}
			time++;
		}
		
		answer = time + bridge_length - bridge.size() + bridge.size();
		return answer;
	}

}
