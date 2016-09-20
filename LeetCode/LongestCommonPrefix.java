package InterviewQuestions;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "a";
		String s3 = "a";
		String[] s = {s1, s2, s3};
		System.out.println(longestCommonPrefix(s));
	}
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder comPrefix = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
        	for(int j = 0; j < strs.length - 1; j++) {
        		if(i >= strs[j+1].length()) return comPrefix.toString();
        		if(strs[j].charAt(i) != strs[j + 1].charAt(i)) return comPrefix.toString();
        	}
        	comPrefix.append(strs[0].charAt(i));
        } 
        return strs[0];
    }
}
