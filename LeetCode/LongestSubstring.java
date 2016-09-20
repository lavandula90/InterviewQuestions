package InterviewQuestions;

import java.util.HashSet;

public class LongestSubstring {
	public static void main(String[] arg) {
		System.out.println(lengthOfLongestSubstring("nfpdmpi"));
	}
	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;
		
		int length = 0;
		int leftbound = 0;
		int size = 0;
		
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				while(leftbound < i && s.charAt(i) != s.charAt(leftbound)) {
					set.remove(s.charAt(leftbound));
					leftbound++;
				}
				leftbound++;
			}
			else {
				set.add(s.charAt(i));
				size = Math.max(set.size(), (i-leftbound+1));
			}
			length = Math.max(length, size);
		}
		return length;
	}
}
