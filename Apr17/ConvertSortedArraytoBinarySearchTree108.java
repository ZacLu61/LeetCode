package Apr17;

import Apr12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArraytoBinarySearchTree108
{
    public ConvertSortedArraytoBinarySearchTree108()
    {
        int[] nums = {-10, -3, 0, 5, 9};

        sortedArrayToBSTIterative(nums);

        sortedArrayToBSTRecursive(nums);
    }

    private TreeNode sortedArrayToBSTRecursive(int[] nums)
    {
        if (nums == null || nums.length == 0) return null;

        return buildTree(nums, 0, nums.length -1);
    }

    private TreeNode buildTree(int[] arr, int start, int end)
    {
        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildTree(arr, start, mid -1);

        root.right = buildTree(arr, mid + 1, end);

        return root;
    }

    private TreeNode sortedArrayToBSTIterative(int[] nums)
    {
        if (nums == null || nums.length == 0) return null;

        int left = 0, right = nums.length - 1, mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        Queue<Integer> leftIndex = new LinkedList<>(), rightIndex = new LinkedList<>();

        leftIndex.add(left);

        rightIndex.add(right);

        while (!queue.isEmpty())
        {
            TreeNode node = queue.remove();

            left = leftIndex.remove();

            right = rightIndex.remove();

            mid = (left + right) / 2;

            node.val = nums[mid];

            if (left <= mid - 1)
            {
                node.left = new TreeNode(0);

                queue.add(node.left);

                leftIndex.add(left);

                rightIndex.add(mid - 1);
            }
            if (right >= mid + 1)
            {
                node.right = new TreeNode(0);

                queue.add(node.right);

                leftIndex.add(mid + 1);

                rightIndex.add(right);
            }
        }
        return root;
    }
}
