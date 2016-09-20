package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 8};
		System.out.print(largestDivisibleSubset(nums));
	}
	public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if(nums.length == 0) return rst;
        Arrays.sort(nums);
        int[] f = new int[nums.length];    //max length until num i
        int[] pre = new int[nums.length];    //pre num of num i
        for(int i = 0; i < nums.length; i++) {
        	f[i] = 1;
        	pre[i] = i;
        	for(int j = 0; j < i; j++) {
        		if(nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
        			f[i] = f[j] + 1;
        			pre[i] = j;
        		}
        	}
        }
        int max = 0;
        int max_i = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(max < f[i]) {
        		max = f[i];
        		max_i = i;
        	}
        }
        rst.add(nums[max_i]);
        while(max_i != pre[max_i]) {
        	max_i = pre[max_i];
        	rst.add(nums[max_i]);
        }
        Collections.reverse(rst);
        return rst;
    }
}
