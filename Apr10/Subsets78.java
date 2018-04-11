package Apr10;

import java.util.ArrayList;
import java.util.List;

public class Subsets78
{
    public Subsets78()
    {
        int[] nums = {1, 2, 3};

        System.out.println(subsets(nums));
    }

    private List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(int[] arr, int start, List<Integer> list, List<List<Integer>> result)
    {   // Add to the result immediately.
        result.add(new ArrayList<>(list));

        for (int i=start; i<arr.length; i++)
        {
            list.add(arr[i]);

            helper(arr, i + 1, list, result);

            list.remove(list.size() -1);
        }
    }
}
