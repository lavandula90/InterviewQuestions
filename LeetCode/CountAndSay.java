package InterviewQuestions;

public class CountAndSay {
	public static void main(String[] s) {
		System.out.println(countAndSay(6));
	}
	
	public static String countAndSay(int n) {
		String str = "1";
        for(int i = 0; i < n-1; i++) {
        	str = say(str);
        }
        return str;
    }
	
	public static String say(String str) {
		StringBuffer say = new StringBuffer();
		int count = 1;
		char last = str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			}
			else {
				say.append(count);
				say.append(last);
				last = str.charAt(i);
				count = 1;
			}
		}
		say.append(count);
		say.append(last);
		return say.toString();
	}
}
