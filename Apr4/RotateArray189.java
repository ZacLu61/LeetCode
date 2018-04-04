package Apr4;

import java.util.ArrayList;
import java.util.List;

public class RotateArray189
{
    public RotateArray189()
    {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        int k = 2;

        rotate(nums, k);

        List<Integer> list = new ArrayList<>();

        for (int num: nums)
            list.add(num);

        System.out.println(list);
    }


    private void rotate(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || k == 0) return;

        k %= nums.length;

        reverse(nums, 0, nums.length -1);

        reverse(nums, 0, k);

        reverse(nums, k + 1, nums.length -1);
    }

    public void reverse(int[]arr, int start, int end)
    {
        while (start < end)
        {
            swap(arr, start++, end--);
        }
    }

    public void swap(int[] arr, int index1, int index2)
    {
        int temp = arr[index1];

        arr[index1] = arr[index2];

        arr[index2] = temp;
    }
}
