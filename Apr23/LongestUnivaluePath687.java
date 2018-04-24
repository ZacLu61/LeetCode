package Apr23;

import Apr12.TreeNode;

public class LongestUnivaluePath687
{
    int max;

    TreeNode root;

    public LongestUnivaluePath687()
    {
        max = 0;

        root = buildTree();

        System.out.println(longestUnivaluePath(root));
    }

    private int longestUnivaluePath(TreeNode root)
    {
        if (root == null) return 0;

        helper(root, root.val);

        return max;
    }

    private int helper(TreeNode node, int val)
    {
        if (node == null) return 0;
        // check left child if value is same as node
        int left = helper(node.left, node.val);
        // check right child
        int right = helper(node.right, node.val);
        // Update max
        max = Math.max(max, left + right);
        // Found match, return 1 (node) + longest of (left, right)
        if (node.val == val)
        {
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    private TreeNode buildTree()
    {
        TreeNode root = new TreeNode(1), cur = root;

        cur.left = new TreeNode(4);

        cur.right = new TreeNode(5);

        cur = root.left;

        cur.left = new TreeNode(4);

        cur.right = new TreeNode(4);

        cur = root.right;

        cur.right = new TreeNode(5);

        return root;
    }
}
