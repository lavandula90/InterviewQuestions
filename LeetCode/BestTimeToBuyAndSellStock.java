package InterviewQuestions;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] a = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(a));
	}
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int price : prices) {
			if(price < minPrice) minPrice = price;
			if(price - minPrice > maxProfit) maxProfit = price - minPrice;
		}
		return maxProfit;
	}
}
