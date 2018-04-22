package Apr21;

public class MaximumSubarray53
{
    public MaximumSubarray53()
    {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    private int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0], len = nums.length;

        int[] dp = new int[len];

        dp[0] = nums[0];

        for (int i=1; i<len; i++)
        {
            dp[i] = Math.max(dp[i -1] + nums[i], nums[i]);

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
