package InterviewQuestions;

public class FindPeakElement {
	public static void main(String[] args) {
		int[] a = {1, 2};
		System.out.println(findPeakElement(a));
	}
	
	public static int findPeakElement(int[] nums) {
		if(nums.length < 2) return 0;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
        	int mid = (start + end) / 2;
        	if(nums[mid] < nums[mid + 1]) {
        		start = mid;
        	}
        	else {
        		end = mid;
        	}
        }
        if(nums[start] < nums[end]) {
        	return end;
        }
        else {
        	return start;
        }
    }
}
