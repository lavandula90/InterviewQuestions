package InterviewQuestions;

public class GuessNumberHigherOrLower {
	public static void main(String[] args) {
		System.out.println(guessNumber(2));
	}
	public static int guessNumber(int n) {
		int left = 0;
		int right = n;
	    while(left < right) {
	    	int rst = left + (right - left) / 2;
	    	if(guess(rst) == 0) return rst;
	    	else if(guess(rst) == 1) left = rst + 1;
	    	else right = rst;
	    }
	    return left;
    }

	private static int guess(int n) {
		if(n == 1) return 0;
		else if(n < 1) return 1;
		else return -1;
	}
}
