package 라인;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	
	public static void main(String[] args) {
		int[] ball = {11, 2, 9, 13, 24};
		int[] order = {9, 2, 13, 24, 11};
		System.out.println(Arrays.toString(solution(ball, order)));
	}
	
	public static int[] solution(int[] ball, int[] order) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
        	map.put(order[i], i);
		}
        int front = 0;
        int end = ball.length - 1;
        for (int i = 0; i < ball.length; i++) {
        	int a = ball[front];
        	int b = ball[end];
        	if(map.get(a) < map.get(b)) {
        		front++;
        		list.add(a);
        	}
        	else {
        		end--;
        		list.add(b);
        	}
		}
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }

}
