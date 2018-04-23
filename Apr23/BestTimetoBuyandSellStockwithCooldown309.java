package Apr23;

public class BestTimetoBuyandSellStockwithCooldown309
{
    public BestTimetoBuyandSellStockwithCooldown309()
    {
        int[] prices = {1, 2, 3, 0, 2};

        System.out.println(maxProfit(prices));
    }

    private int maxProfit(int[] prices)
    {
        int len = prices.length;

        if (len < 2) return 0;

        int[] buy = new int[len], sell = new int[len];

        buy[0] = -prices[0];
        // find max of buy at day1 or buy day2
        buy[1] = Math.max(buy[0], -prices[1]);

        sell[0] = 0;
        // find max of sell at day1 or day2
        sell[1] = Math.max(0, prices[1] - prices[0]);

        for (int i=2; i<len; i++)
        {
            // find max on buy on i-1th day or buy at ith day(sell on i-2th day and buy on ith day due to CD)
            buy[i] = Math.max(buy[i -1], sell[i -2] - prices[i]);
            // find max on sell on i-1th day or sell at ith day(buy on i-1th day and sell on ith day)
            sell[i] = Math.max(sell[i -1], buy[i -1] + prices[i]);
        }
        return sell[len -1];
    }
}
