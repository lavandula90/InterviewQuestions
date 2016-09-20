package InterviewQuestions;

public class RangeSumQuery2DMutable {
	public static void main(String[] args) {
		int[] a1 = {3, 0, 1, 4, 2};
		int[] a2 = {5, 6, 3, 2, 1};
		int[] a3 = {1, 2, 0, 1, 5};
		int[] a4 = {4, 1, 0, 1, 7};
		int[] a5 = {1, 0, 3, 0, 5};
		int[][] a = {a1, a2, a3, a4, a5};
		NumMatrix numMatrix = new NumMatrix(a);
		numMatrix.sumRegion(2, 1, 4, 3);
		numMatrix.update(3, 2, 2);
		numMatrix.sumRegion(2, 1, 4, 3);
		System.out.println(numMatrix.sumRegion(2,1,4,3));
	}
	
	/*private static class NumMatrix {
	    private int[][] matrix;
		public NumMatrix(int[][] matrix) {
	        this.matrix = matrix;
	    }

	    public void update(int row, int col, int val) {
	        matrix[row][col] = val;
	    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        if(row1 < 0 || col1 < 0|| row2 > matrix.length || col2 > matrix[0].length) return 0;
	        int sum = 0;
	        for(int i = row1; i <= row2; i++) {
	        	for(int j = col1; j <= col2; j++) {
	        		sum += matrix[i][j];
	        	}
	        }
	        return sum;
	    }
	}*/
	
	private static class NumMatrix {
		private int[][] matrix;
		private int[][] colSums;
		
		public NumMatrix(int[][] matrix) {
			if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
			this.matrix = matrix;
			int m = matrix.length;
			int n = matrix[0].length;
			colSums = new int[m+1][n];
			for(int i = 1; i <= m; i++) {
				for(int j = 0; j < n; j++) {
					colSums[i][j] = colSums[i-1][j] + matrix[i-1][j];
				}
			}
		}
		
		public void update(int row, int col, int val) {
			for(int i = row + 1; i < colSums.length; i++) {
				colSums[i][col] = colSums[i][col] - matrix[row][col] + val; 
			}
			matrix[row][col] = val;
		}
		
		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			for(int i = col1; i <= col2; i++) {
				sum += colSums[row2 + 1][i] - colSums[row1][i];
			}
			return sum;
		}
	}
}
