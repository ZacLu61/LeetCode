package Apr23;

public class BestTimetoBuyandSellStockIV188
{
    public BestTimetoBuyandSellStockIV188()
    {
        int[] prices = {1, 4, 5, 7, 3, 2, 4, 8, 3, 9, 1};

        int k = 2;

        System.out.println(maxProfit(k, prices));
    }

    private int maxProfit(int k, int[] prices)
    {
        // If k is greater or equal to len/2, it can be bought and sold as many times as we want.
        if (k >= prices.length / 2)
        {
            return bestTimeToBuyAndSellStockII(prices);
        }
        int len = prices.length;
        // DP for buy and sell
        int[][] dp = new int[k + 1][len];

        for (int i=1; i<=k; i++)
        {
            // Assume we buy at the first day, set it to "max" for each time.
            int max = -prices[0];

            for (int j=1; j<len; j++)
            {
                // Compare with sell stock on j-1th day with sell on jth day.
                dp[i][j] = Math.max(dp[i][j -1], max + prices[j]);
                // Update max for not buying stock on jth day or buying on jth day.
                max = Math.max(max, dp[i -1][j] -prices[j]);
            }
        }
        return dp[k][len -1];
    }

    private int bestTimeToBuyAndSellStockII(int[] prices)
    {
        int profit = 0;

        for (int i=1; i<prices.length; i++)
        {
            if (prices[i] > prices[i -1])
            {
                profit += prices[i] - prices[i -1];
            }
        }
        return profit;
    }
}
