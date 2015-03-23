package InterviewQuestions;

public class MaximumSubArray {
	public static void main(String[] args) {
		//int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		int[] array = {-1, -2};
		System.out.println(MaximumSubarray(array));
		
	}
	public static int MaximumSubarray(int[] A) {  
	    int max_sum = Integer.MIN_VALUE;
	    int sum = 0;
	    for(int i = 0; i < A.length; i++) {
	    	if(sum < 0) sum = A[i];
	    	else sum += A[i];
	    	if(sum > max_sum) max_sum = sum;
	    }
	    return max_sum;
	}  
}
