package InterviewQuestions;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
	}
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if(digits == null) return res;
		Map<Character, char[]> map = new HashMap<Character, char[]>();
		map.put('2', new char[] {'a','b','c'});
		map.put('3', new char[] {'d','e','f'});
		map.put('4', new char[] {'g','h','i'});
		map.put('5', new char[] {'j','k','l'});
		map.put('6', new char[] {'m','n','o'});
		map.put('7', new char[] {'p','q','r','s'});
		map.put('8', new char[] {'t','u','v'});
		map.put('9', new char[] {'w','x','y','z'});
		
		StringBuilder builder = new StringBuilder();
		helper(res, map, builder, digits);
		return res;
	}
	public static void helper(List<String> res, Map<Character, char[]> map, StringBuilder builder, String digits) {
		if(digits.length() == 0) return;
		if(builder.length() == digits.length()) {
			res.add(builder.toString());
			return;
		}
		for(char ch : map.get(digits.charAt(builder.length()))) {
			builder.append(ch);
			helper(res, map, builder, digits);
			builder.deleteCharAt(builder.length()-1);
		}
	}
}
