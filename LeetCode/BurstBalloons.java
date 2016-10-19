package InterviewQuestions;

public class BurstBalloons {
	public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        int n = 1;
        for(int num : nums) {
        	balloons[n++] = num;
        }
        balloons[0] = balloons[n++] = 1;
        
        int[][] memo = new int[n][n];
        return burst(memo, balloons, 0, n - 1);
    }
	public int burst(int[][] memo, int[] nums, int left, int right) {
		if(left + 1 == right) return 0;
		if(memo[left][right] > 0) return memo[left][right];
		int ans = 0;
		for(int i = left + 1; i < right; i++) {
			ans = Math.max(ans, nums[left] * nums[i] * nums[right] +
					burst(memo, nums, left, i) + burst(memo, nums, i, right));	
		}
		memo[left][right] = ans;
		return ans;
	}
	
	//DP
	public int maxCoins2(int[] nums) {
		int[] balloons = new int[nums.length + 2];
		int n = 1;
		for(int num : nums) balloons[n++] = num;
		balloons[0] = balloons[n++] = 1;
		int[][] dp = new int[n][n];
		for(int k = 2; k < n; k++) {
			for(int left = 0; left < n - k; left++) {
				int right = left + k;
				for(int i = left + 1; i < right; i++) {
					dp[left][right] = Math.max(dp[left][right], 
							balloons[left] * balloons[i] * balloons[right] + dp[left][i] + dp[i][right]);
				}
			}
		}
		return dp[0][n-1];
	}
}
