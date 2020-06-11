package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
		String[] int_String = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int_String[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(int_String, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub

				if(o2.length() != o1.length()) {
					int min = Math.min(o2.length(), o1.length());
					for (int i = 0; i < min; i++) {
						if(o2.charAt(i) > o1.charAt(i))
							return -1;
						else if(o2.charAt(i) < o1.charAt(i))
							return 1;
					}
					return o2.length() - o1.length();
				}
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i < int_String.length; i++) {
			answer += int_String[i];
		}
		System.out.println("3".compareTo("30"));
		return answer;
	}
}
