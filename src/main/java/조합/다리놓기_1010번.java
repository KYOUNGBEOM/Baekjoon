package 조합;

import java.util.Scanner;

public class 다리놓기_1010번 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] dp = new int[M+1][M+1];
			
			for(int i = 0; i <= M; i++) {
				dp[i][0] = 1;
				dp[i][i] = 1;
				dp[i][1] = i;
			}
			
			for(int i = 2; i <= M; i++) {
				for(int j = 1; j <= i; j++) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
 			}
			
			System.out.println(dp[M][N]);
		}
	}
}
