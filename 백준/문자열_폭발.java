package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		StringBuilder answer = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (answer.length() < bomb.length() - 1)
				answer.append(s.charAt(i));
			else {
				for (int j = 0; j < bomb.length() - 1; j++) {
					sb.append(answer.charAt(answer.length() - 1 - j));
				}
				sb.reverse();
				sb.append(s.charAt(i));
				if (sb.toString().equals(bomb)) {
					answer.delete(answer.length() - bomb.length() + 1, answer.length());
				} else {
					answer.append(s.charAt(i));
				}
			}
			sb.delete(0, sb.length());
		}
		if (answer.length() == 0)
			System.out.println("FRULA");
		else {
			System.out.println(answer.toString());
		}
	}

}
