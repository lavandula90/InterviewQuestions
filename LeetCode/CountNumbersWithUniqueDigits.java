package InterviewQuestions;

public class CountNumbersWithUniqueDigits {
	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(2));
	}
	
	public static int countNumbersWithUniqueDigits(int n) {
		n = Math.min(n, 10);
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
        	dp[i] = 9;
        	for(int j = 9; j >= 9 - i + 2; j--) {
        		dp[i] *= j;
        	}
        }
        
        int count = 0;
        for(int k = 0; k < dp.length; k++) {
        	count += dp[k];
        }
        return count;
    }
}
