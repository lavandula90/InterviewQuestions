package InterviewQuestions;

import java.util.*;

public class BinaryWatch {
	public static void main(String[] args) {
		System.out.print(readBinaryWatch(1));
	}
	public static List<String> readBinaryWatch(int num) {
		List<String> rst = new ArrayList<String>();
		for(int h = 0; h < 12; h++) {
			for(int m = 0; m < 60; m++) {
				if(Integer.bitCount(h * 64 + m) == num) {
					rst.add(String.format("%d:%02d", h, m));
				}
			}
		}
		return rst;
    }
}
