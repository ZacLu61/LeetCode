package Apr11;

public class PartitionEqualSubsetSum416
{
    public PartitionEqualSubsetSum416()
    {
        int[] nums = {1, 5, 11, 5};

//        int[] nums = {1, 2, 3, 5};

        System.out.println(canPartition(nums));
    }

    private boolean canPartition(int[] nums)
    {
        int len = nums.length, sum = 0;

        for (int num: nums)
        {
            sum += num;
        }
        // If sum is odd, means can't be divided into 2 group, sum of each group are the same.
        if (sum % 2 == 1)
            return false;
//         if ((sum & 1) == 1)
//            return false;

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int num: nums)
        {
            for (int i=sum; i>0; i--)
            {
                if (i >= num)
                {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
    }
}
