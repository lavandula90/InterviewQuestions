package InterviewQuestions;

public class ReverseString {
	public static void main(String[] arg) {
		System.out.println(reverseString("Hello"));
	}
	
	public static String reverseString(String s) {
		if (s == null) return null;
		StringBuilder str = new StringBuilder();
		int i;
		for(i = s.length()-1; i >= 0; i--) {
			str.append(s.charAt(i));
		}
		return str.toString();
	}
}
