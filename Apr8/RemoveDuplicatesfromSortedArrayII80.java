package Apr8;

public class RemoveDuplicatesfromSortedArrayII80
{
    public RemoveDuplicatesfromSortedArrayII80()
    {
        int[] nums = {1, 1, 1, 2, 2, 3};

        System.out.println(removeDuplicates(nums));
    }

    /**
     * Time complexity: O(N), N is the length of nums
     *
     * @param nums
     * @return
     */
    private int removeDuplicates(int[] nums)
    {
        if (nums.length <= 2) return nums.length;

        int slow = 1;

        for(int fast=slow+1; fast < nums.length; fast++)
        {
            if (nums[fast] != nums[slow] || nums[fast] == nums[slow] && nums[slow] != nums[slow-1])
            {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
