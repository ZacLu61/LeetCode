package Apr21;

public class BestTimetoBuyandSellStockIII123
{
    public BestTimetoBuyandSellStockIII123()
    {
        int[] nums = {3,3,5,0,0,3,1,4};

        System.out.println(maxProfit(nums));
    }

    private int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0) return 0;
        // Buy is considered as negative
        int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;

        int firstSell = 0, secondSell = 0;

        for (int curPrice: prices)
        {
            if (firstBuy < -curPrice)
            {
                firstBuy = -curPrice;
            }
            if (firstSell < firstBuy + curPrice)
            {
                firstSell = firstBuy + curPrice;
            }
            if (secondBuy < firstSell - curPrice)
            {
                secondBuy = firstSell - curPrice;
            }
            if (secondSell < secondBuy + curPrice)
            {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }
}
