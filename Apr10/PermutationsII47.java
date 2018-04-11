package Apr10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII47
{
    public PermutationsII47()
    {
        int[] nums = {1, 1, 2};

        System.out.println(permuteUnique(nums));
    }

    /**
     * Arrays.sort uses quick sort, worse case n^2 but average case is nlgn
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        Arrays.sort(nums);

        boolean[] visted = new boolean[nums.length];

        helper(nums, visted, new ArrayList<>(), result);

        return result;
    }

    /**
     * Time complexity: O(n^2) worse case, where n is the length of array
     *
     * @param arr
     * @param visited
     * @param list
     * @param result
     */
    private void helper(int[] arr, boolean[] visited, List<Integer> list, List<List<Integer>> result)
    {
        // Base case
        if (list.size() == arr.length)
        {
            result.add(new ArrayList<>(list));

            return;
        }
        for (int i=0; i<arr.length; i++)
        {
            // Visited already
            if (visited[i]) continue;
            // [i -1] has been visited but iteration has not finished, so [i -1] still false;
            if (i > 0 && arr[i] == arr[i -1] && !visited[i -1]) continue;

            visited[i] = true;

            list.add(arr[i]);

            helper(arr, visited, list, result);

            list.remove(list.size() -1);

            visited[i] = false;
        }
    }
}
