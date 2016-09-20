package InterviewQuestions;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
	}
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;
		int div = 1;
		while(x / div >= 10) {
			div *= 10;
		}
		while(x > 0) {
			int h = x / div;
			int l = x % 10;
			if(h != l) return false;
			x = x % div / 10;
			div /= 100;
		}
		return true;
    }
}
