package InterviewQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(lengthLongestPath(str));
	}
	public static int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        int maxLength = 0;
        for(String s : input.split("\n")) {
        	int lvl = s.lastIndexOf("\t") + 1;
        	while(lvl + 1 < stack.size()) stack.pop();
        	int len = stack.peek() + s.length() - lvl + 1;
        	stack.push(len);
        	if(s.contains(".")) {
        		maxLength = Math.max(len - 1, maxLength);
        	}
        }
        return maxLength;
    }
}
