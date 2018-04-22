package Apr21;

public class BestTimetoBuyandSellStock121
{
    public BestTimetoBuyandSellStock121()
    {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }

    private int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0) return 0;

        int min = prices[0], profit = 0;

        for(int i=1; i<prices.length; i++)
        {
            profit = Math.max(profit, prices[i] - min);

            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
