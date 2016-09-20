package InterviewQuestions;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] a = {1,2,4,3};
		System.out.println(maxArea(a));
	}
	
	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int curArea, maxArea = 0;
		while(left < right) {
			curArea = Math.min(height[left], height[right]) * (right-left);
			if(curArea > maxArea) maxArea = curArea;
			if(height[left] < height[right]) left++;
			else if(height[left] > height[right]) right--;
			else {
				left++; 
				right--;
			}
		}
		return maxArea;
	}
}
