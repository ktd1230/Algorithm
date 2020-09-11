package 프로그래머스;

import java.util.Arrays;

public class _1차_비밀지도 {
	
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++)
			answer[i] = "";
		for (int i = 0; i < n; i++) {
			String m1 = Integer.toBinaryString(arr1[i]);
			int len = n - m1.length();
			for (int j = 0; j < len; j++)
				m1 = '0' + m1;
			String m2 = Integer.toBinaryString(arr2[i]);
			len = n - m2.length();
			for (int j = 0; j < len; j++)
				m2 = '0' + m2;
			for (int j = 0; j < n; j++) {
				if(m1.charAt(j) == '1' || m2.charAt(j) == '1')
					answer[i] += '#';
				else
					answer[i] += ' ';
			}
		}
		return answer;
	}

}
