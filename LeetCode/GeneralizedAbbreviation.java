package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
	public static void main(String[] args) {
		System.out.print(generateAbbreviations("word"));
	}
	
	public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(0, word, sb, 0, res);
        return res;
    }
	
	public static void dfs(int pos, String word, StringBuilder sb, int count, List<String> res){
		int sbOriginSize = sb.length();
		if(pos == word.length()) {
			if(count > 0) {
				sb.append(count);
			}
			res.add(sb.toString());
		}
		else {
			dfs(pos+1, word, sb, count+1, res);
			if(count > 0) {
				sb.append(count);
			}
			sb.append(word.charAt(pos));
			dfs(pos+1, word, sb, 0, res);
		}
		sb.setLength(sbOriginSize);
	}
}
