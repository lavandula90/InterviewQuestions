package InterviewQuestions;

public class NextPermutation {
	public static void main(String[] args) {
		int[] a = {3, 2, 1};
		nextPermutation(a);
		System.out.print(a);
	}
	public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int p = -1, q = -1;
        for(int i = nums.length - 1; i > 0; i--) {
        	if(nums[i] > nums[i-1]) {
        		p = i - 1;
        		break;
        	}
        }
        if(p != -1) {
	        for(int i = nums.length - 1; i > p; i--) {
	        	if(nums[i] > nums[p]) {
	        		q = i;
	        		break;
	        	}
	        }
	        swap(nums, p, q);
        }
        for(int i = p + 1, j = nums.length - 1; i < j; i++, j--) {
	        swap(nums, i, j);
	    }
    }
	public static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
	}
}
