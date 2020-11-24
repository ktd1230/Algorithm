package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린_괄호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		boolean check = false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '+' && s.charAt(i) != '-')
				sb.append(s.charAt(i));
			else if(!check) {
				sum += Integer.parseInt(sb.toString());
				sb = new StringBuilder();
			} else if(check) {
				sum -= Integer.parseInt(sb.toString());
				sb = new StringBuilder();
			}
			if(s.charAt(i) == '-') {
				check = true;
			}
		}
		if(check)
			sum -= Integer.parseInt(sb.toString());
		else
			sum += Integer.parseInt(sb.toString());
		System.out.println(sum);
	}

}
