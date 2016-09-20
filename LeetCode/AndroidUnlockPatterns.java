package InterviewQuestions;

public class AndroidUnlockPatterns {
	public static void main(String[] args) {
		System.out.println(numberOfPatterns(1, 2));
	}
	
	public static int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = 
        		skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        int res = 0;
        boolean[] visit = new boolean[10];
        for(int i = m; i <= n; i++) {
        	res += dfs(1, skip, visit, i-1) * 4;
        	res += dfs(2, skip, visit, i-1) * 4;
        	res += dfs(5, skip, visit, i-1);
        }
        return res;
    }
	
	public static int dfs(int cur, int[][] skip, boolean[] visit, int remain) {
		if(remain < 0) return 0;
		if(remain == 0) return 1;
		visit[cur] = true;
		int res = 0;
		for(int i = 1; i <= 9; i++) {
			if(!visit[i] && (skip[cur][i] == 0 || (visit[skip[cur][i]]))) {
				res += dfs(i, skip, visit, remain-1);
			}
		}
		visit[cur] = false;
		return res;
	}
}
