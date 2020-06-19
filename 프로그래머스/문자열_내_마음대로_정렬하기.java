package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {

	public static void main(String[] args) {
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		System.out.println(Arrays.toString(solution(strings, n)));
	}
	public static String[] solution(String[] strings, int n) {
		String[] answer = {};
		ArrayList<String> list = new ArrayList<>();
		for (String str : strings) {
			list.add(str);
		}
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if(o1.charAt(n) == o2.charAt(n))
					return o1.compareTo(o2);
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		
		answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
