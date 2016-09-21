package InterviewQuestions;

public class FindTheDifference {
	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		System.out.println(findTheDifference2(s, t));
	}
	public static char findTheDifference(String s, String t) {
		int[] record = new int[26];
		for(int i = 0; i < s.length(); i++) {
			record[s.charAt(i) - 'a']++;
		}
		for(int i = 0; i < t.length(); i++) {
			if(record[t.charAt(i) - 'a'] == 0) return t.charAt(i);
			record[t.charAt(i) - 'a']--;
		}
		return 0;
	}
	public static char findTheDifference2(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) res ^= c;
        for (char c : t.toCharArray()) res ^= c;
        return res;
    }
}
