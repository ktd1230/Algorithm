package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 제로 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for(int i = 0; i < K; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a != 0) {
				stack.push(a);
				sum += a;
			} else
				sum -= stack.pop();
		}
		System.out.println(sum);
	}

}
