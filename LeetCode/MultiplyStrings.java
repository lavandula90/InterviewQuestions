package InterviewQuestions;

public class MultiplyStrings {
	public static void main(String[] args) {
		String s1 = "13";
		String s2 = "12";
		System.out.println(multiply(s1, s2));
	}
	public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null ) return null;
        int len1 = num1.length();
        int len2 = num2.length();
        int len3 = len1 + len2;
        int[] num3 = new int[len3];
        int i, j, carry, product;
        
        for(i = len1 - 1; i >= 0; i--) {
        	carry = 0;
        	for(j = len2 - 1; j >= 0; j--) {
        		product = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
        		product += num3[i+j+1] + carry;
        		carry = product / 10;
        		num3[i+j+1] = product % 10;
        	}
        	num3[i+j+1] = carry;
        }
        
        StringBuilder res = new StringBuilder();
        i = 0;
        while(i < len3 - 1 && num3[i] == 0) {
        	i++;
        }
        
       while(i < len3) {
    	   res.append(num3[i++]);
       }
       
       return res.toString();
    }
}
