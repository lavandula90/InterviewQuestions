package InterviewQuestions;

public class NimGame {
	public static void main(String[] arg) {
		System.out.println(canWinNim(4));
	}
	
	public static boolean canWinNim(int n) {
		return (n % 4 != 0);
    }
}
