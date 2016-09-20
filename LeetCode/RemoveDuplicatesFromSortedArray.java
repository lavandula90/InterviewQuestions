package InterviewQuestions;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] a = {1,1,2,2,3};
		System.out.println(removeDuplicates(a));
	}
	
	public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != nums[size]) {
        		nums[++size] = nums[i];
        	}
        }
        return size + 1;
    }
}
