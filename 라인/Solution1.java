package 라인;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
	
	public static void main(String[] args) {
//		int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
//		int[][] boxes = {{1, 2}, {3, 4}, {5, 6}};
		int[][] boxes = {{1, 2}, {2, 3}, {3, 1}};
		System.out.println(solution(boxes));
	}
	
	public static int solution(int[][] boxes) {
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < boxes.length; i++) {
        	if(map.get(boxes[i][0]) == null)
        		map.put(boxes[i][0], 1);
        	else
        		map.put(boxes[i][0], map.get(boxes[i][0]) + 1);
        	if(map.get(boxes[i][1]) == null)
        		map.put(boxes[i][1], 1);
        	else
        		map.put(boxes[i][1], map.get(boxes[i][1]) + 1);
			
		}
        int cnt = 0;
        for (Integer value : map.values())
        	if(value % 2 == 0)
        		cnt += value / 2;
        answer = boxes.length - cnt;
        return answer;
    }

}
