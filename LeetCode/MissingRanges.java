package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public static void main(String[] args) {
		int[] a = {0, 1, 3, 50, 75};
		int low = 0;
		int up = 99;
		System.out.print(findMissingRanges(a, low,up));
	}
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> rst = new ArrayList<String>();
        for(int num: nums) {
        	if(num - lower == 1) {
        		rst.add(String.valueOf(lower));
        	}
        	else if(num - lower > 1) {
        		rst.add(lower + "->" + (num - 1));
        	}
        	lower = num + 1;
        }
        if(upper == lower) {
        	rst.add(String.valueOf(upper));
        }
        else if(upper > lower) {
        	rst.add(lower + "->" + (upper));
        }
        return rst;
    }
}
