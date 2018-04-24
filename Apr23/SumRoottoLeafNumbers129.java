package Apr23;

import Apr12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumRoottoLeafNumbers129
{
    TreeNode root;

    public SumRoottoLeafNumbers129()
    {
        root = buildTree();

        System.out.println(sumNumbersRecursive(root));

        root = buildTree();

        System.out.println(sumNumbersUsingQueue(root));

        root = buildTree();

        System.out.println(sumNumbersUsingStack(root));
    }

    private int sumNumbersUsingQueue(TreeNode root)
    {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        int result = 0;

        queue.add(root);

        while (!queue.isEmpty())
        {
            TreeNode node = queue.remove();
            // Leaf node, add to result
            if (node.left == null && node.right == null)
            {
                result += node.val;
            }
            // If left node exist, update left value
            if (node.left != null)
            {
                node.left.val += node.val * 10;

                queue.add(node.left);
            }
            // If right node exist, update right value
            if (node.right != null)
            {
                node.right.val += node.val * 10;

                queue.add(node.right);
            }
        }
        return result;
    }

    private int sumNumbersRecursive(TreeNode root)
    {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum)
    {
        if (node == null) return 0;
        // Update the sum
        sum = sum * 10 + node.val;
        // If leaf node, return sum so far.
        if (node.left == null && node.right == null) return sum;
        // Return left and right sum
        return helper(node.left, sum) + helper(node.right, sum);
    }

    private int sumNumbersUsingStack(TreeNode root)
    {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();

        int result = 0;

        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            // Leaf node, add to result
            if (node.left == null && node.right == null)
            {
                result += node.val;
            }
            // If left node exist, update left value
            if (node.left != null)
            {
                node.left.val += node.val * 10;

                stack.push(node.left);
            }
            // If right node exist, update right value
            if (node.right != null)
            {
                node.right.val += node.val * 10;

                stack.push(node.right);
            }
        }
        return result;
    }

    private TreeNode buildTree()
    {
        TreeNode root = new TreeNode(4), cur = root;

        cur.left = new TreeNode(9);

        cur.right = new TreeNode(0);

        cur = root.left;

        cur.left = new TreeNode(5);

        cur.right = new TreeNode(1);

        return root;
    }
}
