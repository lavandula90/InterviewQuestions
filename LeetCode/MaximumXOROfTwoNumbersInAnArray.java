package InterviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray {
	public static void main(String[] args) {
		int[] n = {3, 10, 5, 25, 2, 8};
		System.out.println(findMaximumXOR(n));
	}
	public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--) {
        	mask = mask | (1 << i);
        	Set<Integer> set = new HashSet<>();
        	for(int num : nums) {
        		set.add(num & mask);
        	}
        	int tmp = max | (1 << i);
        	//If a ^ b = c, then a ^ c = b, b ^ c = a
        	for(int prefix : set) {
        		if(set.contains(tmp ^ prefix)) {
        			max = tmp;
        			break;
        		}
        	}
        }
        return max;
    }
	
	//Method 2
	public int findMaximumXOR2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for(int val : nums) {
			max = Math.max(max, val);
			set.add(val);
		}
		int heighest = getLongestBit(max);
		for(int i = heighest; i >= 0; i--) {
			for(int j = 0; j < nums.length; j++) {
				if(set.contains(nums[j] ^ i)) return i;
			}
		}
		return 0;
	}
	
	public int getLongestBit(int max) {
		int res = 0;
		int bit = 0;
		while(max != 0) {
			res += 1 << bit;
			max >>= 1;
			bit++;
		}
		return res;
	}
}
