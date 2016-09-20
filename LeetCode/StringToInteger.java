package InterviewQuestions;

public class StringToInteger {
	public static void main (String[] args) {
		System.out.println(myAtoi("+-2"));
	}
	
	public static int myAtoi(String str) {
		if(str == null) return 0;
		str = str.trim();
		if(str.length() == 0) return 0;
		
		int sign = 1;
		int index = 0;
		
		if(str.charAt(0) == '+') {
			index++;
		}
		else if(str.charAt(0) == '-') {
			sign = -1;
			index++;
		}
		
		long num = 0;
		
		for(int i = index; i < str.length(); i++) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
			num = num * 10 + (str.charAt(i)-'0');
			if(num > Integer.MAX_VALUE) break;
		}
		
		if(num*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		else if(num*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		return (int) (num*sign);
        
    }
}
