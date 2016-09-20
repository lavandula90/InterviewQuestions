package InterviewQuestions;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
		if(s == null) return -1;
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
        	if(count.get(s.charAt(i)) == null) {
        		count.put(s.charAt(i), 1);
        	}
        	else {
        		count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
        	}
        }
        
        for(int i = 0; i < s.length(); i++) {
        	if(count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
