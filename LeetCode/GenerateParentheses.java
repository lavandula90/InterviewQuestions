package InterviewQuestions;

import java.util.ArrayList;

public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.print(generateParenthesis(4));
	}
	public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if(n <= 0) return res;      
        generateHelper(res, "", n, n);    
        return res;
    }
	
	private static void generateHelper(ArrayList<String> res, String cur, int left, int right) {
		if(left == 0 && right == 0) {
			res.add(cur);
			return;
		}
		
		if(left > 0) {
			generateHelper(res, cur + "(", left - 1, right);
		}
		if(right > 0 && left < right) {
			generateHelper(res, cur + ")", left, right - 1); 
		}
	}
}
