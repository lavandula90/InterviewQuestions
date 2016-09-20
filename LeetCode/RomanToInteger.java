package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		String s = "MMML";
		System.out.println(romanToInt(s));
	}
	public static int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);
	    
	    int length = s.length();
	    int res = m.get(s.charAt(length-1));
	    for(int i = length - 2; i >= 0; i--) {
	    	if(m.get(s.charAt(i)) < m.get(s.charAt(i+1))) {
	    		res -= m.get(s.charAt(i));
	    	}
	    	else {
	    		res += m.get(s.charAt(i));
	    	}
	    }
	    return res;
    }
}
