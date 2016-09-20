package InterviewQuestions;

public class ImplementStrStr {
	public static void main(String[] args) {
		String s1 = "aab";
		String s2 = "ab";
		System.out.println(strStr(s1, s2));
	}
	
	public static int strStr(String haystack, String needle) {
		if(haystack == null || needle == null) return -1;
		int j;
		for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			j = 0;
			for(j = 0; j < needle.length(); j++) {
				if(haystack.charAt(i+j) != needle.charAt(j)) break;
			}
			
			if(j == needle.length()) return i;
		}
		
		return -1;
	}
}
