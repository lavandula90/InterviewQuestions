package InterviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
	public static void main(String[] args) {
		System.out.println(reverseVowels("Aa"));
	}
	public static String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		char[] str = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
        	if(vowels.contains(str[i]) && vowels.contains(str[j])) {
        		char tmp = str[i];
        		str[i] = str[j];
        		str[j] = tmp;
        		i++;
        		j--;
        		continue;
        	}
        	if(!vowels.contains(str[i])) i++;
        	if(!vowels.contains(str[j])) j--;
        }
        return String.valueOf(str);
    }
}
