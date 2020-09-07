package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCD_Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * s + 3; i++) {
			for (int j = 0; j < n.length(); j++) {
				char c = n.charAt(j);
				switch (c) {
				case '0':
					if (i == 0 || i == 2 * s + 2) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else if (i == s + 1) {
						for (int k = 0; k < s + 2; k++) {
							sb.append(' ');
						}
					} else if (i == s + 1)
						break;
					else {
						sb.append('|');
						for (int k = 0; k < s; k++) {
							sb.append(' ');
						}
						sb.append('|');
					}
					break;
				case '1':
					if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						for (int k = 0; k < s + 2; k++) {
							sb.append(' ');
						}
					} else {
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
						sb.append('|');
					}
					break;
				case '2':
					if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else if (i < s + 1) {
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
						sb.append('|');
					} else {
						sb.append('|');
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
					}
					break;
				case '3':
					if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else {
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
						sb.append('|');
					}
					break;
				case '4':
					if (i == 0 || i == 2 * s + 2) {
						for (int k = 0; k < s + 2; k++) {
							sb.append(' ');
						}
					} else if (i == s + 1) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else if (i < s + 1) {
						sb.append('|');
						for (int k = 0; k < s; k++) {
							sb.append(' ');
						}
						sb.append('|');
					} else {
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
						sb.append('|');
					}
					break;
				case '5':
					if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else if (i > s + 1) {
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
						sb.append('|');
					} else {
						sb.append('|');
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
					}
					break;
				case '6':
					if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else if (i > s + 1) {
						sb.append('|');
						for (int k = 0; k < s; k++) {
							sb.append(' ');
						}
						sb.append('|');
					} else {
						sb.append('|');
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
					}
					break;
				case '7':
					if (i == 0) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						for (int k = 0; k < s + 2; k++) {
							sb.append(' ');
						}
					} else {
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
						sb.append('|');
					}
					break;
				case '8':
					if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else {
						sb.append('|');
						for (int k = 0; k < s; k++) {
							sb.append(' ');
						}
						sb.append('|');
					}
					break;
				case '9':
					if (i == 0 || i == 2 * s + 2 || i == s + 1) {
						sb.append(' ');
						for (int k = 1; k < s + 1; k++) {
							sb.append('-');
						}
						sb.append(' ');
					} else if (i < s + 1) {
						sb.append('|');
						for (int k = 0; k < s; k++) {
							sb.append(' ');
						}
						sb.append('|');
					} else {
						for (int k = 0; k < s + 1; k++) {
							sb.append(' ');
						}
						sb.append('|');
					}
					break;
				}
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());

	}

}
