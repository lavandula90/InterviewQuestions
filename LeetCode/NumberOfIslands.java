package InterviewQuestions;

public class NumberOfIslands {
	public static void main(String[] args) {
		char[] a1 = {'1','1','1','1','0'};
		char[] a2 = {'1','1','0','1','0'};
		char[] a3 = {'1','1','0','0','0'};
		char[] a4 = {'0','0','0','0','0'};
		char[][] a = {a1, a2, a3, a4};
		
		System.out.println(numIslands(a));
	}
	
	private static int m;
	private static int n;
	
	public static void dfs(char[][]grid, int i, int j) {
		if(i < 0 || i >= m || j < 0 || j >= n) return;
		
		if(grid[i][j] == '1') {
			grid[i][j] = '0';
			dfs(grid, i+1, j);
			dfs(grid, i-1, j);
			dfs(grid, i, j+1);
			dfs(grid, i, j-1);
		}
	}
	
	public static int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        if(n == 0) return 0;
        
        int count = 0;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(grid[i][j] == '0') continue;
        		count++;
        		dfs(grid, i, j);
        	}
        }
        return count;
    }
}
