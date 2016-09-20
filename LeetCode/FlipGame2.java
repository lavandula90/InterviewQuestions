package InterviewQuestions;

public class FlipGame2 {
	public static void main(String[] args){
		System.out.println(canWin("++++"));
	}
	public static boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.startsWith("++", i)) {
        		String t = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
        		
        		if(!canWin(t)) return true;
        	}
        }
        return false;
    }
}
