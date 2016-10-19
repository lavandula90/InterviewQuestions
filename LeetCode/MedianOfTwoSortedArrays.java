package InterviewQuestions;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int A[] = {1, 3, 5, 7, 9};
		int B[] = {2, 6};
		System.out.println(findMedianSortedArrays(A, B));
	}
	
	//Binary search
	public static double findMedianSortedArray(int[] num1, int[] num2) {
		int len = num1.length + num2.length;
		if (len % 2 == 1) {
			return findKth(num1, 0, num2, 0, len/2+1);
		}
		else {
			return ( findKth(num1, 0, num2, 0, len/2) + findKth(num1, 0, num2, 0, len/2+1) ) / 2.0;
		}
	}
	
	public static double findKth(int[] A, int start_A, int[] B, int start_B, int k) {
		if(start_A >= A.length) {
			return B[start_B+k-1];
		}
		if(start_B >= B.length) {
			return A[start_A+k-1];
		}
		if (k == 1) {
			return Math.min(A[start_A], B[start_B]);
		}
		
		int A_key = (start_A + k/2 - 1) < A.length ? A[start_A + k/2 -1] : Integer.MAX_VALUE;
		int B_key = (start_B + k/2 - 1) < B.length ? B[start_B + k/2 -1] : Integer.MAX_VALUE;
		
		if(A_key < B_key) {
			return findKth(A, start_A + k/2, B, start_B, k-k/2);
		}
		else {
			return findKth(A, start_A, B, start_B + k/2, k-k/2);
		}
	}
	
	//O(logN)
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int med1 = 0, med2 = 0, i = 0, j = 0;
        while(i + j <= (m + n)/2){
        	if(i < n && j < m){
        		med2 = med1;
        		if(nums1[i] < nums2[j]){
        			med1 = nums1[i];
        			i++;
        		}else{
        			med1 = nums2[j];
        			j++;
        		}
        	}
        	else if(i < n){
        		med2 = med1;
        		med1 = nums1[i];
        		i++;
        		}
        	else if(j < m){
        		med2 = med1;
        		med1 = nums2[j];
        		j++;
        	}
        	
        }
        if((m + n) % 2 == 0) return (med1 + med2)/2.0;
        return med1;
    }
}
