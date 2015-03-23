package InterviewQuestions;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		int k = 3;
		rotate(nums, k);
		System.out.println(nums[0]);
	}
	public static void rotate(int[] nums, int k) {
		int len = nums.length;
        int tmp = 0, j = 0, cnt = 0;
        k = k % len;
        if(k == 0) return;
        for(int i=0; i<=len; i++) {
            tmp ^= nums[j]; 
            nums[j] ^= tmp; 
            tmp ^= nums[j];
            if(j == cnt && i != 0) {
                j++;
                if(j == k || i == len) {
                    break;
                }
                tmp ^= nums[j]; 
                nums[j] ^= tmp; 
                tmp ^= nums[j];
                cnt++;
            }
            j += k;
            if(j > len-1) {
                j = j- len;
            }
        }
	}
}
