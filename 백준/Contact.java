package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String pattern = "^(10(0)+(1)+|01)+$";
		if (s.matches(pattern))
			System.out.println("SUBMARINE");
		else
			System.out.println("NOISE");
	}

}
