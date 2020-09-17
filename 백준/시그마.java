package 백준;
import java.util.Scanner;

public class 시그마 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextInt();
		long b = sc.nextInt();

		long A = Math.min(a, b);
		long B = Math.max(a, b);
		long sum = 0;

		long sum_plus = B * (B + 1) / 2;
		long sum_minus = A * (A - 1) / 2;

		sum = sum_plus - sum_minus;
		
		System.out.println(sum);
	}

}
