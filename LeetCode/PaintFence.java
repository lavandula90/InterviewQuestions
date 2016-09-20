package InterviewQuestions;

public class PaintFence {
	public static void main(String[] args) {
		System.out.println(numWays(2, 2));
	}
	
	public static int numWays(int n, int k) {
        if(n == 0) return  0;
        if(n == 1) return k;
        int same = 0;
        int diff = k; 
        int total = k;
        for(int i = 2; i <= n; i++) {
        	same = diff; 
        	diff = (k - 1) * total;
        	total = same + diff;
        }
        return total;
    }
}
