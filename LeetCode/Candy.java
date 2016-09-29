package InterviewQuestions;

import java.util.Arrays;

public class Candy {
	public static void main(String[] args) {
		int[] rates = {4, 2, 3, 4, 1};
		System.out.println(candy(rates));
	}
	public static int candy(int[] ratings) {
		int rst = 0;
		if(ratings.length == 0) return rst;
		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		for(int i = 0; i < ratings.length - 1; i++) {
			if(ratings[i] < ratings[i + 1]) candies[i + 1] = candies[i] + 1;
		}
		for(int i = ratings.length - 1; i > 0; i--) {
			if(ratings[i] < ratings[i - 1] && candies[i - 1] <= candies[i]) candies[i - 1] = candies[i] + 1;
		}
		for(int i = 0; i < candies.length; i++) {
			rst += candies[i];
		}
		return rst;
	}
}
