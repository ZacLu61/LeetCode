package Apr16;

import Apr12.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII107
{
    TreeNode root;

    public BinaryTreeLevelOrderTraversalII107()
    {
        root = buildTree();

        System.out.println(levelOrderBottomIterative(root));

        System.out.println(levelOrderBottomRecursive(root));
    }

    private List<List<Integer>> levelOrderBottomRecursive(TreeNode root)
    {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        helper(root, 0, result);

        return result;
    }

    private void helper(TreeNode node, int level, LinkedList<List<Integer>> result)
    {
        if (node == null) return;

        if (level >= result.size())
        {
            result.addFirst(new LinkedList<>());
        }
        result.get(result.size() -1 - level).add(node.val);

        level++;

        helper(node.left, level, result);

        helper(node.right, level, result);
    }

    private List<List<Integer>> levelOrderBottomIterative(TreeNode root)
    {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            List<Integer> list = new LinkedList<>();

            for (int i=0; i<size; i++)
            {
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
            result.addFirst(list);
        }
        return result;
    }

    private TreeNode buildTree()
    {
        TreeNode root = new TreeNode(3), cur = root;

        cur.left = new TreeNode(9);

        cur.right = new TreeNode(20);

        cur = root.right;

        cur.left = new TreeNode(15);

        cur.right = new TreeNode(7);

        return root;
    }
}
