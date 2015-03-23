package InterviewQuestions;

import java.util.*;
public class ValidParentheses {
	public static void main(String[] s) {
		String brackets = "[(])";
		boolean valid = isValid(brackets);
		System.out.println(valid);
	}
	
	public static boolean isValid(String s) {
		if(s.length() % 2 == 1) return false;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(!stack.isEmpty()) {
				if(isPair(stack.peek(), temp)) {
					stack.pop();
					continue;
				}
				else {
					stack.push(temp);
				}
			}
			else stack.push(temp);
		}
        if(stack.isEmpty()) return true;
        else return false;
    }
	
	public static boolean isPair(char ch1, char ch2) {
		if(ch1 == '(' && ch2 == ')') return true;
		else if(ch1 == '[' && ch2 == ']') return true;
		else if(ch1 == '{' && ch2 == '}') return true;
		else return false;
	}
}
