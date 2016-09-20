package InterviewQuestions;

public class StrobogrammaticNumber {
	public static void main(String[] args) {
		String s = "2";
		System.out.println(isStrobogrammatic(s));
	}
	
	public static boolean isStrobogrammatic(String num) {
		int length = num.length();
        for(int i = 0, j = length - 1; i <= j; i++, j--) {
        	if(num.charAt(i) == '2' || num.charAt(i) == '3' || num.charAt(i) == '4' ||
        			num.charAt(i) == '5' || num.charAt(i) == '7') return false;
        	if(num.charAt(j) == '2' || num.charAt(j) == '3' || num.charAt(j) == '4' ||
        			num.charAt(j) == '5' || num.charAt(j) == '7') return false;
        	if(num.charAt(i) == '0' && num.charAt(j) != '0') return false;
        	if(num.charAt(i) == '1' && num.charAt(j) != '1') return false;
        	if(num.charAt(i) == '8' && num.charAt(j) != '8') return false;
        	if(num.charAt(i) == '6' && num.charAt(j) != '9') return false;
        	if(num.charAt(i) == '9' && num.charAt(j) != '6') return false;
        }
        return true;
    }
}
