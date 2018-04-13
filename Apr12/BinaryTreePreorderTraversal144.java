package Apr12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144
{
    List<Integer> result;

    public BinaryTreePreorderTraversal144()
    {
        result = new ArrayList<>();
    }

    private List<Integer> preorderTraversalIterative(TreeNode root)
    {
        if (root == null) return result;

        TreeNode cur = root;

        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty())
        {
            if (cur != null)
            {
                result.add(cur.val);

                stack.push(cur);

                cur = cur.left;
            }
            else
            {
                TreeNode temp = stack.pop();

                cur = temp.right;
            }
        }
        return result;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root)
    {
        if (root == null) return result;

        result.add(root.val);

        preorderTraversalRecursive(root.left);

        preorderTraversalRecursive(root.right);

        return result;
    }
}
