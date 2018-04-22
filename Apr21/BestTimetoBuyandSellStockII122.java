package Apr21;

public class BestTimetoBuyandSellStockII122
{
    public BestTimetoBuyandSellStockII122()
    {
        int[] nums = {7,1,5,3,6,4};

        System.out.println(maxProfit(nums));
    }

    private int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0) return 0;

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
