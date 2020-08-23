package 쏘카;

public class Solution1 {
	
	public static void main(String[] args) {
//		String[] bakery_schedule = {"09:05 10", "12:20 5", "13:25 6", "14:24 5"};
//		String current_time = "12:05";
//		int K = 10;
		String[] bakery_schedule = {"12:00 10"};
		String current_time = "12:00";
		int K = 10;
//		String[] bakery_schedule = {"12:00 10"};
//		String current_time = "12:00";
//		int K = 11;
		System.out.println(solution(bakery_schedule, current_time, K));
	}
	
	public static int solution(String[] bakery_schedule, String current_time, int K) {
		int answer = -1;
		int cTime = Integer.parseInt(current_time.split(":")[0]) * 60 + Integer.parseInt(current_time.split(":")[1]);
		int total_bbang = 0;
		int[] time = new int[bakery_schedule.length];
		int[] bbang = new int[bakery_schedule.length];
		for(int i = 0; i < bakery_schedule.length; i++) {
			time[i] = Integer.parseInt(bakery_schedule[i].split(":")[0]) * 60 + Integer.parseInt(bakery_schedule[i].split(":")[1].split(" ")[0]);
			bbang[i] = Integer.parseInt(bakery_schedule[i].split(" ")[1]);
		}
		for(int i = 0; i < time.length; i++) {
			if(time[i] < cTime)
				continue;
			total_bbang += bbang[i];
			if(total_bbang >= K) {
				answer = time[i] - cTime;
				break;
			}
		}
		return answer;
	}

}
