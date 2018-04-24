package Apr23;

public class BestTimetoBuyandSellStockwithTransactionFee714
{
    public BestTimetoBuyandSellStockwithTransactionFee714()
    {
        int[] prices = {1,3,2,8,4,9};

        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }

    private int maxProfit(int[] prices, int fee)
    {
        if (prices == null || prices.length == 0) return 0;
        // Buy at day1, sell 0
        int buy = -prices[0], sell = 0;

        for (int i=1; i<prices.length; i++)
        {   // Find max between previous buy or buy on ith day, then update buy
            buy = Math.max(buy, sell -prices[i]);
            // Find max between previous sell or sell on ith day with fee, then update sell
            sell = Math.max(sell, buy + prices[i] - fee);
        }
        return sell;
    }
}
