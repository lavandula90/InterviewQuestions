package InterviewQuestions;

public class IntegerToRoman {
	public static void main(String[] args) {
		int a = 3050;
		System.out.println(intToRoman(a));
	}
	
	public static String intToRoman(int num) {
		if(num < 0) return "";
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder res = new StringBuilder();
	    int digit = 0;
	    while(num > 0) {
	    	int times = num/nums[digit];
	    	for(int i = 0; i < times; i++) {
	    		res.append(symbols[digit]);
	    	}
	    	num = num - nums[digit] * times;
	    	digit++;
	    }
	    
	    return res.toString();
    }
}
