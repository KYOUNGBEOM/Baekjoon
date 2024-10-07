package 재귀;

import java.util.Scanner;

public class 백준_피보나치수5_10870번 {
	static int[]fibo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		fibo = new int[21];
		
		fibo[0] = 0;
		fibo[1] = 1;
		
		calculateFibo(2);
		
		System.out.println(fibo[n]);
	}
	
	static void calculateFibo(int depth) {
		if(depth == 21) {
			return;
		}
		
		fibo[depth] = fibo[depth-2] + fibo[depth-1];
		calculateFibo(depth + 1);
	}
}
