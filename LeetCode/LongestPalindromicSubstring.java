package InterviewQuestions;

public class LongestPalindromicSubstring {
	public static void main(String[] arg) {
		String str = "abbc";
		System.out.println(longestPalindrome(str));
	}
	public static String longestPalindrome(String s) {
		if (s == null) return null;
		if (s.length() == 1) return s;
		int max = 0;
		int len = 0;
		String max_str = null;
		for (int i = 0; i < s.length(); i++) {
			int j;
			for (j = 0; (i - j) >= 0 && (i + j) < s.length(); j++) {    //length of palindrome is odd number 
				if (s.charAt(i-j) != s.charAt(i+j)) break;
				len = j * 2 + 1;
			}
			if(len > max) {
				max = len;
				max_str = s.substring(i-j+1, i+j);
			}
			
			for (j = 0; (i - j) >= 0 && (i + j + 1) < s.length(); j++ ) {    //length of palindrome is even number
				if (s.charAt(i-j) != s.charAt(i+j+1)) break;
				len = j * 2 + 2;
			}
			if(len > max) {
				max = len;
				max_str = s.substring(i-j+1, i+j+1);
			}
		}
			
		return max_str;
    }
}
