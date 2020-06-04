package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
	
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String player : participant) {
			if(map.get(player) == null)
				map.put(player, 1);
			else
				map.put(player, map.get(player) + 1);
		}
		
		for (String player : completion) {
			map.put(player, map.get(player) - 1);
		}
		
		for (String player : participant) {
			if(map.get(player) == 1)
				answer = player;
		}
		
		return answer;
	}
}
