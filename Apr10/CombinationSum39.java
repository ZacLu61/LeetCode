package Apr10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39
{
    public CombinationSum39()
    {
        int[] candidates = {2, 3, 6, 7};

        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

    /**
     * Time complexity: O(nlgn) Arrays.sort uses quick sort. Average is nlgn, worse for n^2
     * n is the length of array.
     *
     * @param candidates
     * @param target
     * @return
     */
    private List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates);

        helper(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    /**
     * Time complexity: O(NM) worse case, where N is the length of array; M is target.
     *
     * @param arr
     * @param start
     * @param target
     * @param list
     * @param result
     */
    private void helper(int[] arr, int start, int target, List<Integer> list, List<List<Integer>> result)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(list));

            return;
        }
        for (int i=start; i<arr.length && target >= arr[i]; i++)
        {   // Remove duplicated
            if (i > start && arr[i] == arr[i -1]) continue;

            list.add(arr[i]);
            // start remains i, because it can be reused.
            helper(arr, i, target - arr[i], list, result);

            list.remove(list.size() -1);
        }
    }
}
