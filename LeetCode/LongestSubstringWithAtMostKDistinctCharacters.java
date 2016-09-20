package InterviewQuestions;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public static void main(String[] args) {
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
	}
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s == null || s.length() == 0 || k <= 0) return 0;
		int max = 0;
		int start  = 0;
		int num = 0;
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++) {
        	if(count[s.charAt(i)]++ == 0) num++;
        	if (num > k) {
        		while(--count[s.charAt(start++)] > 0);
        		num--;
        	}
        	max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
