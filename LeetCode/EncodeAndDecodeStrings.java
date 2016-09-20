package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();
		strs.add("");
		System.out.print(decode(encode(strs)));
	}
	// Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String s : strs) {
        	builder.append(s);
        	builder.append("-");
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
    	List<String> rst = new ArrayList<String>();
    	for(String str : s.split("-")) {
    		rst.add(str);
    	}
    			
		return rst;
    }
}
