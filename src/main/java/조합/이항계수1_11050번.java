package 조합;

import java.util.Scanner;

public class 이항계수1_11050번 {
	static int[] factorial;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		factorial = new int[N+1];
		
		factorial[0] = 1;
		
		for(int i = 1; i <= N; i++) {
			factorial[i] = i * factorial[i-1];
		}
		
		System.out.println(factorial[N] / factorial[N-K] / factorial[K]);
	}
}
