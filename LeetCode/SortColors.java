package InterviewQuestions;

public class SortColors {
	public static void main(String[] args) {
		int[] a = {1, 2, 0};
		sortColors(a);
	}
	public static void sortColors(int[] nums) {
        if(nums.length == 0) return;
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        int temp;
        while(i <= blue) {
        	if(nums[i] == 1) {
        		i++;
        		continue;
        	}
        	else if(nums[i] == 0) {
        		temp = nums[i];
        		nums[i] = nums[red];
        		nums[red] = temp;
        		red++;
        		i++;
        	}
        	else {
        		temp = nums[i];
        		nums[i] = nums[blue];
        		nums[blue] = temp;
        		blue--;
        	}
        }
	}
}
 
