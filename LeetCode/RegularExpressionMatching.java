package InterviewQuestions;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("aab","c*a*b"));
	}
	
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return (s.length() == 0);
		}
		
		if (p.length() == 1 || p.charAt(1) != '*') {
			if(s.length() < 1) return false;
			else if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') return false;
			else return isMatch(s.substring(1), p.substring(1));
		}
		
		else {
			int i = -1;
			while(i < s.length() && (i<0 || s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if(isMatch(s.substring(i+1), p.substring(2))) return true;
				i++;
			}
		}
		return false;
	}
}
