package 조합;

import java.util.Scanner;

public class 백준_팩토리얼_10872번 {
	static int[] factorial = new int[13];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		factorial[0] = 1;
		factorial[1] = 1;
		
		for(int i = 1; i <= 12; i++) {
			factorial[i] = i * factorial[i-1];
		}
		
		System.out.println(factorial[N]);
	}
}
