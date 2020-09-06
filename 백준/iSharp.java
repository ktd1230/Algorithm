package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iSharp {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] res = br.readLine().split(" ");
		for (int i = 1; i < res.length; i++) {
			System.out.print(res[0]);
			int idx = 0;
			for (int j = 0; j < res[i].length(); j++) {
				if(res[i].charAt(j) < 'A' || res[i].charAt(j) > 'Z' && res[i].charAt(j) < 'a' || res[i].charAt(j) > 'z') {
					idx = j;
					break;
				}
			}
			System.out.println(new StringBuilder(res[i].substring(idx, res[i].length() - 1).replace("[]", "][")).reverse() + " " +res[i].substring(0, idx) + ";");
		}
	}

}
