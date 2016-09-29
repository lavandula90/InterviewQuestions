package InterviewQuestions;

import java.util.*;

public class PalindromePermutation {
	public static void main(String[] args) {
		String s = "as";
		System.out.println(canPermutePalindrome(s));
	}
	public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
        	if(!map.containsKey(c)) map.put(c, 1);
        	else map.put(c, map.get(c) + 1);
        }
        boolean hasOneOdd = false;
        for(char key : map.keySet()) {
        	int a = map.get(key);
        	if(a % 2 == 0) continue;
        	if(!hasOneOdd) hasOneOdd = true;
        	else return false;
        }
        return true;
    }
}
