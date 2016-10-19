package InterviewQuestions;

public class IntegerReplacement {
	public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32;    //n = 2 ^ 32 - 1;
        int count = 0;
        while(n > 1) {
        	if(n % 2 == 0) n /= 2;
        	else {
        		if((n + 1) % 4 == 0 && (n - 1 != 2)) n += 1;
        		else n -= 1;
        	}
        	count++;
        }
        return count;
    }
	
	public int integerReplacement2(int n) {
		if(n == 1) return 0;
		if(n % 2 == 0) return 1 + integerReplacement2(n / 2);
		else {
			long t = n;
			return 2 + Math.min(integerReplacement2((int) ((t + 1) / 2)), integerReplacement2((int) ((t -1) / 2)));
		}
	}
}
