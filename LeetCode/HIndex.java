package InterviewQuestions;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		int[] a = {3, 0, 6, 1, 5};
		System.out.println(hIndex(a));
	}
	public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for(int i = 0; i < citations.length; i++) {
        	int curH = Math.min(citations[i], citations.length - i);
        	if(curH > h) h = curH;
        }
        return h;
    }
}
