package 백준;

import java.util.Scanner;

public class 막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		int ans = 0;
		while (X > 0) {
			int s = 1;
			while (s <= X)
				s *= 2;
			if(s != 1)
				s /= 2;
			X -= s;
			ans++;
		}
		
		System.out.println(ans);
	}
}