package InterviewQuestions;

import java.util.*;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, num, "", 0, 0, 0, target);
        return rst;
    }
	
	public void helper(List<String> rst, String num, String path, int pos, long sum, long lastNum, int target) {
		int len = num.length();
		if(pos == len && sum == target) {
			rst.add(path);
			return;
		}
		if(pos >= len) return;
		for(int i = pos; i < len; i++) {
			if(i != pos && num.charAt(pos) == '0') break;
			long curNum = Long.parseLong(num.substring(pos, i + 1)); 
			if(pos == 0) {
				helper(rst, num, path + "" + curNum, i + 1, curNum, curNum, target); 
			}
			else {
				helper(rst, num, path + "+" + curNum, i + 1, sum + curNum, curNum, target);  
                helper(rst, num, path + "-" + curNum, i + 1, sum - curNum, -curNum, target);  
                helper(rst, num, path + "*" + curNum, i + 1, sum - lastNum + lastNum * curNum, lastNum * curNum, target); 
			}
		}
	}
}
