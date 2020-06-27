package 백준;
import java.util.Scanner;

public class 스위치_켜고_끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		int N = sc.nextInt();
		int[] swit = new int[N];

		for (int i = 0; i < N; i++) {
			swit[i] = sc.nextInt();
		}

		int std_num = sc.nextInt();
		int[][] stds = new int[std_num][2];
		for (int i = 0; i < std_num; i++) {
			stds[i][0] = sc.nextInt();
			stds[i][1] = sc.nextInt();
		}

		for (int i = 0; i < std_num; i++) {
			if (stds[i][0] == 1) {
				change_man(swit, stds[i][1], N);
			} else if (stds[i][0] == 2) {
				change_woman(swit, stds[i][1], N);
			}
		}
		for (int i = 0; i < N; i++) {
			if (i > 1 && (i + 1) % 20 == 1)
				System.out.println();
			System.out.print(swit[i] + " ");
		}
	}

	static void change_man(int[] arr, int idx, int N) {
		int a = 1;
		int multi = idx;
		while (idx - 1 < N) {
			if (arr[idx - 1] == 0)
				arr[idx - 1] = 1;
			else 
				arr[idx - 1] = 0;
			idx = multi * ++a;
		}
	}

	static void change_woman(int[] arr, int idx, int N) {
		int a = 1;
		boolean flag = false;
		while (idx + a - 1 < N && idx - a - 1 >= 0) {
			if (arr[idx + a - 1] == arr[idx - a - 1]) {
				if (arr[idx + a - 1] == 0) {
					arr[idx + a - 1] = 1;
					arr[idx - a - 1] = 1;
				} else {
					arr[idx + a - 1] = 0;
					arr[idx - a - 1] = 0;
				}
				a++;
			} else
				break;
		}
		if (arr[idx - 1] == 0)
			arr[idx - 1] = 1;
		else
			arr[idx - 1] = 0;

	}
}
