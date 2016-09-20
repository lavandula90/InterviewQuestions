package InterviewQuestions;

public class MaximumProductOfWordLengths {
	public static void main(String[] args) {
		String s1 = "abcw";
		String s2 = "baz";
		String s3 = "foo";
		String s4 = "bar";
		String s5 = "xtfn";
		String s6 = "abcdef";
		String[] words = {s1, s2, s3, s4, s5, s6};
		System.out.println(maxProduct(words));
	}
	public static int maxProduct(String[] words) {
        int max = 0;
        int[] bitMask = new int[words.length];
        for(int i = 0; i < words.length; i++) {
        	for(char ch : words[i].toCharArray()) {
        		bitMask[i] |= 1 << (ch - 'a');
        	}
        }
        
        for(int i = 0; i < words.length; i++) {
        	for(int j = i; j < words.length; j++) {
        		if((bitMask[i] & bitMask[j]) == 0) {
        			max = Math.max(max, (words[i].length() * words[j].length()));
        		}
        	}
        }
        return max;
    }
}
