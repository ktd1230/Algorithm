package 프로그래머스;

import java.util.*;

public class 소수_찾기 {
	
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
		int answer = 0;
		char[] nums = numbers.toCharArray();
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i <= nums.length; i++)
			perm(nums, new char[i], 0, new boolean[nums.length], set);
		answer = set.size();
		return answer;
	}
	
	public static void perm(char[] nums, char[] sel, int r, boolean[] visited, Set<Integer> set) {
		if(sel.length == r) {
			String num = "";
			for(int i = 0; i < sel.length; i++) {
				num += sel[i];
			}
			int number = Integer.parseInt(num);
			boolean check = true;
			for(int i = 2; i < number; i++) {
				if(number % i == 0) {
					check = false;
					break;
				}
			}
			if(check && number > 1)
				set.add(number);
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			sel[r] = nums[i];
			perm(nums, sel, r + 1, visited, set);
			visited[i] = false;
		}
	}

}
