package Apr16;

import Apr12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree111
{
    int depth;

    public MinimumDepthofBinaryTree111()
    {
        depth = Integer.MAX_VALUE;
    }

    private int minDepthRecursive1(TreeNode root)
    {
        if (root == null) return 0;

        helper(root, 1);

        return depth;
    }

    private void helper(TreeNode node, int level)
    {
        if (node == null || level >= depth) return;

        if (node.left == null && node.right == null)
        {
            depth = level;

            return;
        }
        level++;

        helper(node.left, level);

        helper(node.right, level);
    }

    private int minDepthRecursive2(TreeNode root)
    {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left == null)
        {
            return minDepthRecursive2(root.right) + 1;
        }
        if (root.right == null)
        {
            return minDepthRecursive2(root.left) + 1;
        }
        return Math.min(minDepthRecursive2(root.left), minDepthRecursive2(root.right)) + 1;
    }

    private int minDepthIterative(TreeNode root)
    {
        if (root == null) return 0;

        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            level++;

            int size = queue.size();

            for (int i=0; i<size; i++)
            {
                TreeNode node = queue.remove();

                if (node.left == null && node.right == null) return level;

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
        }
        return level;
    }
}
