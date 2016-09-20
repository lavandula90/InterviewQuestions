package InterviewQuestions;

import java.util.Arrays;

public class PerfectSquares {
	public static void main(String[] args) {
		System.out.println(numSquares(13));
	}
	public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; i++) {
        	dp[i * i] = 1; 
        }
        for(int i = 0; i <= n; i++) {
        	for(int j = 0; i + j * j <= n; j++) {
        		dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
        	}
        }
        return dp[n];
    }
}
