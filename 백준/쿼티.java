package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼티 {
	static String line = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			String fixed = "";
			for (int i = 0; i < readLine.length(); i++) {
				boolean check = false;
				for (int j = 0; j < line.length(); j++) {
					if (readLine.charAt(i) == line.charAt(j)) {
						fixed += line.charAt(j - 1);
						check = true;
					}
				}
				if(!check)
					fixed += readLine.charAt(i);
			}
			System.out.println(fixed);
		}
	}
}
