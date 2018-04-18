package Apr17;

import Apr12.TreeNode;

public class BalancedBinaryTree110
{
    TreeNode root;

    public BalancedBinaryTree110()
    {
        root = buildTree();

        System.out.println(isBalanced(root));
    }

    private boolean isBalanced(TreeNode root)
    {
        if (root == null) return true;

        int left = getHeight(root.left);

        int right = getHeight(root.right);

        if (Math.abs(left - right) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node)
    {
        if (node == null) return 0;

        int left = getHeight(node.left);

        int right = getHeight(node.right);

        return Math.max(left, right) + 1;
    }

    private TreeNode buildTree()
    {
        TreeNode root = new TreeNode(1), cur = root;

        cur.left = new TreeNode(2);

        cur.right = new TreeNode(2);

        cur = root.left;

        cur.left = new TreeNode(3);

        cur.right = new TreeNode(3);

        cur = cur.left;

        cur.left = new TreeNode(4);

        cur.right = new TreeNode(4);

        return root;
    }
}
