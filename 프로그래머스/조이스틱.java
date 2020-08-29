package 프로그래머스;

public class 조이스틱 {

	public static void main(String[] args) {
		String name = "JAN";
		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		int answer = 0;
		int idx = 0;
		char[] nameC = name.toCharArray();
		for(int k = 0; k < name.length(); k++) {
			int r_idx = idx;
			int l_idx = idx;
			for(int i = 0; i < nameC.length; i++) {
				if(nameC[idx] != 'A') {
					answer += Math.min(nameC[idx] - 'A', 26 - (nameC[idx] - 'A'));
					nameC[idx] = 'A';
					break;
				}
				r_idx++;
				r_idx %= nameC.length;
				if(nameC[r_idx] != 'A') {
					idx = r_idx;
					answer += i + 1 + Math.min(nameC[idx] - 'A', 26 - (nameC[idx] - 'A'));
					nameC[idx] = 'A';
					break;
				}
				l_idx--;
				if(l_idx == -1)
					l_idx = nameC.length - 1;
				if(nameC[l_idx] != 'A') {
					idx = l_idx;
					answer += i + 1 + Math.min(nameC[idx] - 'A', 26 - (nameC[idx] - 'A'));
					nameC[idx] = 'A';
					break;
				}
			}
		}
		return answer;
	}
	
}
