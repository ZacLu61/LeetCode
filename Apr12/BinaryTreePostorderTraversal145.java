package Apr12;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145
{
    LinkedList<Integer> result;

    public BinaryTreePostorderTraversal145()
    {
        result = new LinkedList<>();
    }

    private List<Integer> postorderTraversal(TreeNode root)
    {
        if (root == null) return result;

        TreeNode cur = root;

        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty())
        {
            if (cur != null)
            {
                result.addFirst(cur.val);

                stack.push(cur);

                cur = cur.right;
            }
            else
            {
                TreeNode temp = stack.pop();

                cur = temp.left;
            }
        }
        return result;
    }

    private List<Integer> postorderTraversalRecursive(TreeNode root)
    {
        if (root == null) return result;

        postorderTraversalRecursive(root.left);

        postorderTraversalRecursive(root.right);

        result.add(root.val);

        return result;
    }
}
