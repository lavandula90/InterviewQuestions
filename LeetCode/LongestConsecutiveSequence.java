package InterviewQuestions;

import java.util.*;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int maxLength = 0;
		for(int i = 0; i < nums.length; i++) {
			int down = nums[i] - 1;
			while(set.contains(down)) {
				set.remove(down);
				down--;
			}
			int up = nums[i] + 1;
			while(set.contains(up)) {
				set.remove(up);
				up++;
			}
			maxLength = Math.max(maxLength, up-down-1);
		}
		return maxLength;
	}
}
