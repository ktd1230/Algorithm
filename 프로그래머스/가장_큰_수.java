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
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		for (int i = 0; i < int_String.length; i++) {
			if(answer.equals("0"))
				answer = int_String[i];
			else
				answer += int_String[i];
		}
		
		return answer;
	}
}
