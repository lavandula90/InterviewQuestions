package InterviewQuestions;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	public static void main(String[] args) {
		int num = -1;
		int den = -2147483648;
		System.out.println(fractionToDecimal(num, den));
	}
	public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long remainder = num % den;
        builder.append(sign);
        builder.append(num/den);
        if(remainder == 0) return builder.toString();
        builder.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        while(!hashMap.containsKey(remainder)) {
        	hashMap.put(remainder, builder.length());
        	builder.append(10 * remainder / den);
        	remainder = 10 * remainder % den; 
        }
        int index = hashMap.get(remainder);
        builder.insert(index, "(");
        builder.append(")");
        return builder.toString().replace("(0)", "");
    }
}
