package Apr10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations46
{
    public Permutations46()
    {
        int[] nums = {1, 2, 3};

        System.out.println(permuteRecursive(nums));

        System.out.println(permuteIterative(nums));
    }

    private List<List<Integer>> permuteRecursive(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        helper(nums, 0, result);

        return result;
    }

    private void helper(int[] arr, int start, List<List<Integer>> result)
    {
        // Finished the iteration
        if (start == arr.length)
        {
            List<Integer> list = new ArrayList<>();

            for (int num: arr)
            {
                list.add(num);
            }
            result.add(new ArrayList<>(list));

            return;
        }
        for (int i=start; i<arr.length; i++)
        {
            swap(arr, i, start);
            // increment to start + 1, not i + 1, for thread safe.
            helper(arr, start + 1, result);

            swap(arr, i, start);
        }
    }

    private void swap(int[] arr, int index1, int index2)
    {
        int temp = arr[index1];

        arr[index1] = arr[index2];

        arr[index2] = temp;
    }

    private List<List<Integer>> permuteIterative(int[] nums)
    {
        LinkedList<List<Integer>> result = new LinkedList<>();

        result.add(new LinkedList<>());

        for (int num: nums)
        {
            // Check how many iterations to run
            int size = result.size();

            for (int i=0; i<size; i++)
            {
                List<Integer> list = result.removeFirst();
                // Add num to index: 0, 1, ...siz()
                // Backtracking
                for (int j=0; j<=list.size(); j++)
                {
                    list.add(j, num);

                    result.add(new LinkedList<>(list));

                    list.remove(j);
                }
            }
        }
        return result;
    }
}
