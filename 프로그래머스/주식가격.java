package 프로그래머스;

import java.util.*;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(prices)));
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < prices.length; i++) {
			int num = i;
			boolean check = false;
			for(int j = i; j < prices.length; j++) {
				if(prices[j] < prices[num]) {
					num = j - num;
					check = true;
					break;
				}
			}
			if(!check)
				num = prices.length - num - 1;
			
			list.add(num);
		}
		answer = new int[list.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
