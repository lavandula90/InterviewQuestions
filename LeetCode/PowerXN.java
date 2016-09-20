package InterviewQuestions;

public class PowerXN {
	public static void main(String[] args) {
		System.out.println(myPow(2, 3));
	}
	
	public static double myPow(double x, int n) {
        if(n < 0) {
        	return 1 / helper(x, -n);
        }
        else {
        	return helper(x, n);
        }
    }
	
	public static double helper(double x, int n) {
		if(n == 0) return 1;
		double v = helper(x, n / 2);
		if(n % 2 == 0) {
			return (v * v);
		}
		else {
			return (v * v * x);
		}
	}
}
