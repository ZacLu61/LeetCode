package Apr12;

import java.util.Stack;

public class ValidateBinarySearchTree98
{
    public ValidateBinarySearchTree98() { }

    private boolean isValidBSTIterative(TreeNode root)
    {
        if (root == null) return true;

        TreeNode cur = root, pre = null;

        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty())
        {
            while (cur != null)
            {
                stack.push(cur);

                cur = cur.left;
            }
            cur = stack.pop();

            if (pre == null)
            {
                pre = cur;
            }
            else
            {
                if (pre.val >= cur.val) return false;

                pre = cur;
            }
            cur = cur.right;
        }
        return true;
    }

    private boolean isValidBSTRecusive(TreeNode root)
    {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer low, Integer high)
    {
        if (node == null) return true;

        boolean checkLow = low == null || low < node.val;

        boolean checkHigh = high == null || node.val < high;

        return checkLow && checkHigh && valid(node.left, low, node.val) && valid(node.right, node.val, high);
    }
}
