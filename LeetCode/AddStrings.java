package InterviewQuestions;

import java.util.Arrays;

public class AddStrings {
	public String addStrings(String num1, String num2) {
        if(num1.length() == 0 && num2.length() == 0) return "";
        char[] num11 = num1.toCharArray();
        char[] num22 = num2.toCharArray();
        char[] rst = new char[Math.max(num11.length, num22.length) + 1];
        Arrays.fill(rst, '0');
        int i = num11.length - 1;
        int j = num22.length - 1;
        int k = rst.length - 1;
        while(k >= 0) {
        	int value = rst[k] - '0';
        	if(i >= 0) value += num11[i--] - '0';
        	if(j >= 0) value += num22[j--] - '0';
        	if(value >= 10) {
        		rst[k - 1] = '1';
        	}
        	rst[k] = (char)('0' + value % 10);
        	k--;
        }
        k = 0;
        while(k < rst.length - 1 && rst[k] == '0') k++;
        return String.valueOf(rst, k, rst.length - k);
    }
}
