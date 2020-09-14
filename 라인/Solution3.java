package 라인;

import java.util.Arrays;

public class Solution3 {

	static int min;
	static int val;

	static void rec(String s, int d) {
		if (s.length() == 1) {
			min = Math.min(min, d);
			if (min == d)
				val = Integer.parseInt(s);
			return;
		} else {
			for (int mid = 1; mid < s.length(); mid++) {
				String as = s.substring(0, mid);
				String bs = s.substring(mid, s.length());
				if (bs.length() != 1 && bs.charAt(0) == '0')
					continue;
				int a = Integer.parseInt(as);
				int b = Integer.parseInt(bs);
				rec(Integer.toString(a + b), d + 1);
			}
		}
	}

	public static int[] solution(int n) {
		min = Integer.MAX_VALUE;
		String ns = Integer.toString(n);
		rec(ns, 0);
		return new int[] { min, val };
	}

	public static void main(String[] args) {
		int[] r1 = solution(73425);
		System.out.println(Arrays.toString(r1));
		int[] r2 = solution(10007);
		System.out.println(Arrays.toString(r2));
		int[] r3 = solution(9);
		System.out.println(Arrays.toString(r3));
		int[] r4 = solution(1000000000);
		System.out.println(Arrays.toString(r4));
		int[] r5 = solution(999999999);
		System.out.println(Arrays.toString(r5));

	}
}