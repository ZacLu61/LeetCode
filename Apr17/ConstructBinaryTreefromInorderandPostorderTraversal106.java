package Apr17;

import Apr12.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal106
{
    int inPtr, postPtr;

    public ConstructBinaryTreefromInorderandPostorderTraversal106() { }

    private TreeNode buildTree(int[] inorder, int[] postorder)
    {
        inPtr = inorder.length -1;

        postPtr = postorder.length -1;

        return helper(inorder, postorder, null);
    }

    private TreeNode helper(int[] inorder, int[] postorder, TreeNode end)
    {
        if (postPtr < 0) return null;

        TreeNode root = new TreeNode(postorder[postPtr--]);

        if (inorder[inPtr] != root.val)
        {
            root.right = helper(inorder, postorder, root);
        }
        inPtr--;

        if (end == null || inorder[inPtr] != end.val)
        {
            root.left = helper(inorder, postorder, end);
        }
        return root;
    }
}
