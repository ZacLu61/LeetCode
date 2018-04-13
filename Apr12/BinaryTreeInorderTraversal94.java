package Apr12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94
{
    List<Integer> result;

    public BinaryTreeInorderTraversal94()
    {
        result = new ArrayList<>();
    }

    private List<Integer> inorderTraversalIterative(TreeNode root)
    {
        if (root == null) return result;

        TreeNode cur = root;

        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty())
        {
            if (cur != null)
            {
                stack.push(cur);

                cur = cur.left;
            }
            else
            {
                TreeNode node = stack.pop();

                result.add(node.val);

                cur = node.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root)
    {
        if (root == null) return result;

        inorderTraversalRecursive(root.left);

        result.add(root.val);

        inorderTraversalRecursive(root.right);

        return result;
    }
}
