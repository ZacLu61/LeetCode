package Apr15;

import Apr12.TreeNode;

import java.util.Stack;

public class SymmetricTree101
{
    TreeNode root1;

    TreeNode root2;

    public SymmetricTree101() {
        TreeNode root1 = new TreeNode(1);

        TreeNode root2 = new TreeNode(2);

        buildTree1(root1);

        buildTree2(root2);

        System.out.println(isSymmetricIterative(root1));

        System.out.println(isSymmetricRecursive(root1));

        System.out.println(isSymmetricIterative(root2));

        System.out.println(isSymmetricRecursive(root2));

    }

    private boolean isSymmetricRecursive(TreeNode root)
    {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right)
    {
        if (left == null || right == null)
        {
            return left == right;
        }
        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    private boolean isSymmetricIterative(TreeNode root)
    {
        if (root == null) return true;

        TreeNode left = root.left, right = root.right;

        Stack<TreeNode> stack = new Stack<>();

        if (left != null)
        {
            if (right == null) return false;

            stack.push(left);

            stack.push(right);
        }
        else if (right != null) return false;

        while (!stack.isEmpty())
        {
            if (stack.size() % 2 == 1) return false;

            right = stack.pop();

            left = stack.pop();

            if (left.val != right.val) return false;

            if (left.left != null)
            {
                if (right.right == null) return false;

                stack.push(left.left);

                stack.push(right.right);
            }
            else if (right.right != null) return false;

            if (left.right != null)
            {
                if (right.left == null) return false;

                stack.push(left.right);

                stack.push(right.left);
            }
            else if (right.left != null) return false;
        }
        return true;
    }

    private void buildTree1(TreeNode root)
    {
        TreeNode cur = root;

        cur.left = new TreeNode(2);

        cur.right = new TreeNode(2);

        cur = cur.left;

        cur.left = new TreeNode(3);

        cur.right = new TreeNode(4);

        cur = root.right;

        cur.left = new TreeNode(4);

        cur.right = new TreeNode(3);
    }

    private void buildTree2(TreeNode root)
    {
        root.left = new TreeNode(2);

        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(3);
    }
}
