package Epic;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		int[] res = MaximumSubArray(array);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	public static int[] MaximumSubArray(int[] A){  
	    if (A.length < 2){  
	        return null;  
	    }  
	    if (A.length == 2){  
	        return A;  
	    }  
	    int maxStart = 0;  
	    int maxEnd = 1;  
	    int maxHereStart = 0;  
	    int maxHereEnd = 1;  
	    int maxEndHere = A[0] + A[1];  
	    int maxSoFar = Integer.MIN_VALUE;  
	  
	    for (int i = 2; i < A.length; i++){  
	        if (A[i] + A[i-1] > (maxEndHere + A[i])){  
	            maxEndHere = A[i]+A[i-1];  
	            maxHereEnd = i;  
	            maxHereStart = i-1;  
	        }  
	        else{  
	            maxEndHere = maxEndHere + A[i];  
	            maxHereEnd = i;  
	        }  
	  
	        if (maxEndHere > maxSoFar){  
	            maxSoFar = maxEndHere;  
	            maxStart = maxHereStart;  
	            maxEnd = maxHereEnd;  
	        }  
	    }  
	    int[] res = new int[maxEnd-maxStart+1];  
	    for (int k = 0; k <= (maxEnd-maxStart); k++){  
	        res[k] = A[maxStart+k];  
	    }  
	    return res;  
	}  
}
