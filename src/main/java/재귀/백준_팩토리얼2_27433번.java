package 재귀;

import java.util.Scanner;

public class 백준_팩토리얼2_27433번 {
	static long[] factorial;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		factorial = new long[N+1];
		
		factorial[0] = 1;
		
		calculateFactorial(1);
		
		System.out.println(factorial[N]);
	}
	
	public static void calculateFactorial(int depth) {
		if(depth == factorial.length) {
			return;
		}
		
		factorial[depth] = depth * factorial[depth-1];
		calculateFactorial(depth+1);
	}
}
