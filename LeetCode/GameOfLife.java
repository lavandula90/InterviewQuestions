package InterviewQuestions;

public class GameOfLife {
	public static void main(String[] args) {
		int[] a1 = {0, 1, 0, 1};
		int[] a2 = {1, 0, 1, 0};
		int[][] a = {a1, a2};
		gameOfLife(a);
		System.out.println(a);
	}
	
	public static void gameOfLife(int[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        if(n == 0) return;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		int neighbor = numOfNeighbors(board, i, j, m, n);
        		if(board[i][j] == 0 && neighbor == 3) {
        			board[i][j] = 2;
        		}
        		else if(board[i][j] == 1 && neighbor >= 2 && neighbor <= 3) {
        			board[i][j] = 3;
        		}
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		board[i][j] >>= 1;
        	}
        }
    }
	
	public static int numOfNeighbors(int[][] board, int i, int j, int m, int n) {
    	int count = 0;
    	for(int s = i - 1; s <= i + 1; s++) {
    		for(int w = j - 1; w <= j + 1; w++) {
    			if(s < 0 || s >= m || w < 0 || w >= n) continue;
    			if(s == i && w == j) continue;
    			if(board[s][w] == 1 || board[s][w] == 3) count++;
    		}
    	}
    	return count;
    }
}
