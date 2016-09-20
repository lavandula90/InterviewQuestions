package InterviewQuestions;

public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(7));
	}
	public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
