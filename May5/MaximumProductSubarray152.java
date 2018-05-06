package May5;

public class MaximumProductSubarray152
{
    public MaximumProductSubarray152()
    {
        int[] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }

    private int maxProduct(int[] nums)
    {
        if (nums == null || nums.length == 0) return 0;
        // Could be negative and positive, need min and max;
        // result set as first element
        int min = nums[0], max = min, result = min;

        for (int i=1; i<nums.length; i++)
        {   // temp for max
            int cur = nums[i], temp = max;
            // Find out [cur, max * cur, min * min] which one is max
            max = Math.max(cur, Math.max(max * cur, min * cur));
            // max is updated, use temp for findding out min
            min = Math.min(cur, Math.min(temp * cur, min * cur));
            // Update result
            result = Math.max(result, max);
        }
        return result;
    }
}
