package May5;

public class HouseRobber198
{
    public HouseRobber198()
    {
        int[] nums = {1,2,3,1};

        System.out.println(rob(nums));
    }

    private int rob(int[] nums)
    {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        // Rob first one or second one
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i=2; i<nums.length; i++)
        {   // Rob [i-1], or [i-2] and current one
            dp[i] = Math.max(dp[i -1], dp[i -2] + nums[i]);
        }
        return dp[dp.length -1];
    }
}
