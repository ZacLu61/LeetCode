package Apr15;

import Apr12.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102
{
    TreeNode root;

    public BinaryTreeLevelOrderTraversal102()
    {
        root = new TreeNode(3);

        buildTree(root);

        System.out.println(levelOrderRecursive(root));

        System.out.println(levelOrderIterative(root));
    }

    private List<List<Integer>> levelOrderRecursive(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, root, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode node, int level)
    {
        if (node == null) return;

        if (level >= result.size())
        {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        helper(result, node.left, level + 1);

        helper(result, node.right, level + 1);
    }

    private List<List<Integer>> levelOrderIterative(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            int level = queue.size();

            List<Integer> list = new LinkedList<>();

            for (int i=0; i<level; i++)
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
            result.add(list);
        }
        return result;
    }

    private void buildTree(TreeNode root)
    {
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);

        root.right.right = new TreeNode(7);
    }
}
