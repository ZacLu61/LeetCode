package Apr13;

import Apr12.TreeNode;

public class RecoverBinarySearchTree99
{
    TreeNode first;

    TreeNode second;

    TreeNode pre;

    public RecoverBinarySearchTree99()
    {
        first = second = null;

        pre = new TreeNode(Integer.MIN_VALUE);
    }

    public void recoverTree(TreeNode root)
    {
        if (root == null) return;

        inorder(root);

        swap(first, second);
    }

    private void inorder(TreeNode node)
    {
        if (node == null) return;

        inorder(node.left);

        if (first == null && pre.val >= node.val)
        {
            first = pre;
        }
        if (first != null && pre.val >= node.val)
        {
            second = node;
        }
        pre = node;

        inorder(node.right);
    }

    private void swap(TreeNode node1, TreeNode node2)
    {
        int temp = node1.val;

        node1.val = node2.val;

        node2.val = temp;
    }
}
