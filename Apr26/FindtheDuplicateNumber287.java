package Apr26;

public class FindtheDuplicateNumber287
{
    public FindtheDuplicateNumber287()
    {
//        int[] nums = {1,2,5,4,3,6,9,7,8,4};

        int[] nums = {1,3,4,2,2};

        System.out.println(findDuplicate(nums));
    }

    private int findDuplicate(int[] nums)
    {
        if (nums == null || nums.length == 0) return -1;

        int slow = nums[0], fast = nums[slow];

        while (fast != slow)
        {
            slow = nums[slow];

            fast = nums[nums[fast]];
        }
        fast = 0;

        while (fast != slow)
        {
            fast = nums[fast];

            slow = nums[slow];
        }
        return fast;
    }
}
