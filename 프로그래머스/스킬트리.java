package 프로그래머스;

import java.util.*;

public class 스킬트리 {
	
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.out.println(solution(skill, skill_trees));
	}
	
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < skill.length(); i++) {
			map.put(skill.charAt(i), i);
		}
		for(int i = 0; i < skill_trees.length; i++) {
			Stack<Integer> stack = new Stack<>();
			boolean isOk = true;
			for(int j = 0; j < skill_trees[i].length(); j++) {
				int num = map.get(skill_trees[i].charAt(j)) != null ? map.get(skill_trees[i].charAt(j)) : -1;
				if(num != -1) {
					if(stack.isEmpty() && num == 0)
						stack.push(num);
					else if(!stack.isEmpty() && stack.peek() == num - 1)
						stack.push(num);
					else {
						isOk = false;
						break;
					}
				}
			}
			if(isOk)
				answer++;
		}
		
		return answer;
	}

}
