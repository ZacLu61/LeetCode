package Grind75;

class BestTimeToBuyAndSellStock121 {
    
    public int maxProfit(int[] prices) {
        // Check corner case
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStock121().maxProfit(prices));
    }
}