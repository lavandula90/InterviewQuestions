package InterviewQuestions;

public class RemoveElement {
	public static void main(String[] args) {
		int[] a = {1,3,1,5,1,6,1,2};
		int v = 1;
		System.out.println(removeElement(a,v));
	}
	public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != val) {
        		nums[size++] = nums[i];
        	}
        }
        return size;
    }
}
