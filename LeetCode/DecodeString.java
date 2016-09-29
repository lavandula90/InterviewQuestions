package InterviewQuestions;

import java.util.*;

public class DecodeString {
	public static void main(String[] args) {
		String s = "100[leetcode]";
		System.out.println(decodeString(s));
	}
	
	public static String decodeString(String s) {
        Stack<Integer> count = new Stack<Integer>();
        Stack<String> result = new Stack<String>();
        int i = 0;
        result.push("");
        while(i < s.length()) {
        	char c = s.charAt(i);
        	if(c >= '0' && c <= '9') {
        		int start = i;
        		while(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
        		count.push(Integer.parseInt(s.substring(start, i + 1)));
        	}
        	else if(c == '[') result.push("");
        	else if(c == ']') {
        		String str = result.pop();
        		StringBuilder sb = new StringBuilder();
        		int times = count.pop();
        		for(int j = 0; j < times; j++) {
        			sb.append(str);
        		}
        		result.push(result.pop() + sb.toString());
        	}
        	else {
        		result.push(result.pop() + c);
        	}
        	i++;
        }
        return result.pop();
    }
}
