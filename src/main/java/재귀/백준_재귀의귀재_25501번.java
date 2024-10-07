package 재귀;

import java.util.Scanner;

public class 백준_재귀의귀재_25501번 {
	static int depth;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String S = sc.next();
			depth = 0;
			
			System.out.println(isPalindrome(S) + " " + depth);
		}
	}
	
	static int recursion(String s, int l, int r) {
		depth++;
		if(l >= r) return 1;
		
		if(s.charAt(l) != s.charAt(r)) return 0;
	
		return recursion(s, l+1, r-1);
	}
	
	static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}
}
