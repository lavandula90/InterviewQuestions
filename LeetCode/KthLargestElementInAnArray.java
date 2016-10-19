package InterviewQuestions;

import java.util.*;

public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		int[] a = {3,2,1,5,6,4};
		System.out.println(findKthLargest(a, 2));
	}
	public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(k <= 0) return 0;
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }
	
	public static int helper(int[] nums, int l, int r, int k) {
		if(l == r) return nums[l];
		int position = partition(nums, l, r);
		if(position + 1 == k) {
			return nums[position];
		}
		else if(position + 1 < k) {
			return helper(nums, position + 1, r, k);			
		}
		else {
			return helper(nums, l, position - 1, k);
		}
	}
	
	public static int partition(int[] nums, int l, int r) {
		int left = l;
		int right = r;
		int pivot = nums[left];
		while (left < right) {
			while (left < right && nums[right] >= pivot) {
				right--;
			}
			nums[left] = nums[right];
			while(left  < right && nums[left] <= pivot) {
				left++;
			}
			nums[right] = nums[left];
		}
		nums[left] = pivot;
		return left;
	}
	
	//quick select
	public int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
	    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
	}    

	public int quickSelect(int[] nums, int start, int end, int k) {// quick select: kth smallest
		if (start > end) return Integer.MAX_VALUE;
		
		int pivot = nums[end];// Take A[end] as the pivot, 
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
				swap(nums, left++, i);			
		}
		swap(nums, left, end);// Finally, swap A[end] with A[left]
		
		if (left == k)// Found kth smallest number
			return nums[left];
		else if (left < k)// Check right part
			return quickSelect(nums, left + 1, end, k);
		else // Check left part
			return quickSelect(nums, start, left - 1, k);
	} 

	void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;				
	}
	
	//max heap
	public int findKthLargest3(int[] nums, int k) {
	    Queue<Integer> priorityQueue = new PriorityQueue<>(k);
	    for(int i:nums){
	    	if(priorityQueue.size()==k){
	    		if(priorityQueue.peek()<i){
	    			priorityQueue.poll();
	    			priorityQueue.add(i);
	    		}
	    	}else{
	    		priorityQueue.add(i);
	    	}
	    }
	    return priorityQueue.peek();
	}
	
}
