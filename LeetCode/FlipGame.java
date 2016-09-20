package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	public static void main(String[] args) {
		System.out.print(generatePossibleNextMoves("++++"));
	}
	public static List<String> generatePossibleNextMoves(String s) {
		List<String> rst = new ArrayList<String>();
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				rst.add(new String(s.substring(0, i) + "--" + s.substring(i + 2, s.length())));
			}
		}
		return rst;
    }
}
