package Apr10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90
{
    public SubsetsII90()
    {
        int[] nums = {1, 2, 2};

        System.out.println(subsetsWithDup(nums));
    }

    private List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;
        // Sorted, for check duplication
        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(int[] arr, int start, List<Integer> list, List<List<Integer>> result)
    {
        result.add(new ArrayList<>(list));

        for (int i=start; i<arr.length; i++)
        {   // Check duplicated
            if (i > start && arr[i] == arr[i -1]) continue;

            list.add(arr[i]);

            helper(arr, i + 1, list, result);

            list.remove(list.size() -1);
        }
    }
}
