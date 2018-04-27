package Apr26;

import java.util.Arrays;

public class FindtheDuplicateNumber287
{
    public FindtheDuplicateNumber287()
    {
//        int[] nums = {1,2,5,4,3,6,9,7,8,4};

        int[] nums = {1,3,4,2,2};

        System.out.println(findDuplicateAsLinkedList(nums));

        System.out.println(findDuplicateUsingSort(nums));
    }

    private int findDuplicateAsLinkedList(int[] nums)
    {
        if (nums == null || nums.length == 0) return -1;
        // Like LL
        int slow = nums[0], fast = nums[slow];
        // Find the mid point (duplicated index or element)
        while (fast != slow)
        {
            fast = nums[nums[fast]];

            slow = nums[slow];
        }
        // Set fast = 0 to check again
        // Last round could stop in index, not element
        fast = 0;
        // 1 iteration 1 time
        while (fast != slow)
        {
            fast = nums[fast];

            slow = nums[slow];
        }
        return fast;
    }

    private int findDuplicateUsingSort(int[] nums)
    {
        if (nums == null || nums.length == 0) return -1;
        // Sorted
        Arrays.sort(nums);

        for (int i=0; i<nums.length -1; i++)
        {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }
}
