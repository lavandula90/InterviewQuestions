package InterviewQuestions;

public class ReverseInteger {
	public static void main(String[] arg) {
		System.out.println(reverse(-1));
	}
	public static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			if (res != 0 && Integer.MAX_VALUE / res < 10 && Integer.MAX_VALUE / res > -10) return 0;
			res = res*10 + x%10;
			x = x/10;
		}
		return res;	
	}
}
