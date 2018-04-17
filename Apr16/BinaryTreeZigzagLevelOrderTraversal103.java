package Apr16;

import Apr12.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103
{
    TreeNode root;

    public BinaryTreeZigzagLevelOrderTraversal103()
    {
        root = buildTree();

        System.out.println(zigzagLevelOrderIterative(root));

        System.out.println(zigzagLevelOrderRecursive(root));
    }

    private List<List<Integer>> zigzagLevelOrderRecursive(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();

        helper(root, res, 0);

        return res;
    }

    private void helper(TreeNode node, List<List<Integer>> res, int level)
    {
        if (node == null) return;

        if (level >= res.size())
        {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0)
        {
            res.get(level).add(node.val);
        }
        else
        {
            res.get(level).add(0, node.val);
        }
        helper(node.left, res, level+1);

        helper(node.right, res, level+1);
    }

    private List<List<Integer>> zigzagLevelOrderIterative(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            LinkedList<Integer> list = new LinkedList<>();

            for (int i=0; i<size; i++)
            {
                TreeNode node = queue.poll();

                if (level % 2 == 0)
                {
                    list.add(node.val);
                }
                else
                {
                    list.addFirst(node.val);
                }
                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
            level++;

            result.add(list);
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
