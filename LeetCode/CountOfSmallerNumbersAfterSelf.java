package InterviewQuestions;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
	public static void main(String[] args) {
		int[] nums = {5, 2, 6, 1};
		System.out.print(countSmaller2(nums));
	}
	//Binary Search
	public static List<Integer> countSmaller(int[] nums) {
        Integer[] rst = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        for(int i = nums.length - 1; i >= 0; i--) {
        	int index = findIndex(sorted, nums[i]);
        	rst[i] = index;
        	sorted.add(index, nums[i]);
        }
        
        return Arrays.asList(rst);
    }
	
	public static int findIndex(List<Integer> sorted, int target) {
		if(sorted.size() == 0) return 0;
		int start = 0;
		int end = sorted.size() - 1;
		if(sorted.get(end) < target) return end + 1;
		if(sorted.get(start) >= target) return 0;
		while(start < end) {
			int mid = start + (end - start) / 2;
			if(sorted.get(mid) < target) start = mid + 1;
			else end = mid;
		}
		if(sorted.get(start) >= target) return start;
		return end;
	}
	
	//BIT
	public static List<Integer> countSmaller2(int[] nums) {
		List<Integer> rst = new LinkedList<Integer>();
		if(nums == null || nums.length == 0) return rst;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		int[] nums2 = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i] - min + 1;
			max = Math.max(max, nums2[i]);
		}
		int[] tree = new int[max + 1];
		for(int i = nums2.length - 1; i >= 0; i--) {
			rst.add(0, get(nums2[i] - 1, tree));
			update(nums2[i], tree);
		}
		return rst;
	}
	
	public static int get(int i, int[] tree) {
		int num = 0;
		while(i > 0) {
			num += tree[i];
			i -= i & (-i);
		}
		return num;
	}
	
	public static void update(int i, int[] tree) {
		while(i < tree.length) {
			tree[i]++;
			i += i & (-i);
		}
	}
}
