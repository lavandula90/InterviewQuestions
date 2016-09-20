package InterviewQuestions;

public class BestTimeToBuyAndSellStockWithCooldown {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 0, 2};
		System.out.println(maxProfit(a));
	}
	public static int maxProfit(int[] prices) {
		int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}
