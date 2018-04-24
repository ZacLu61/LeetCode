package Apr23;

import Apr12.TreeNode;

public class BinaryTreeMaximumPathSum124
{
    // Or use int[1] for passed by reference
    int max = Integer.MIN_VALUE;

    TreeNode root;

    public BinaryTreeMaximumPathSum124()
    {
        root = buildTree();

        System.out.println(maxPathSum(root));
    }

    private int maxPathSum(TreeNode root)
    {
        if (root == null) return 0;

        helper(root);

        return max;
    }

    private int helper(TreeNode node)
    {
        if (node == null) return 0;
        // If negative, return 0 (not choosing this path)
        int left = Math.max(0, helper(node.left));

        int right = Math.max(0, helper(node.right));
        // Update max
        max = Math.max(max, node.val + left + right);
        // Determining which route after current value
        return Math.max(left, right) + node.val;
    }

    private TreeNode buildTree()
    {
        TreeNode root = new TreeNode(-10), cur = root;

        cur.left = new TreeNode(9);

        cur.right = new TreeNode(20);

        cur = root.right;

        cur.left = new TreeNode(15);

        cur.right = new TreeNode(7);

        return root;
    }
}
