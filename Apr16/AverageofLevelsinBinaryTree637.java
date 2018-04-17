package Apr16;

import Apr12.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree637
{
    TreeNode root;

    public AverageofLevelsinBinaryTree637()
    {
        root = buildTree();

        System.out.println(averageOfLevelsIterative(root));

        System.out.println(averageOfLevelsRecursive(root));
    }

    private List<Double> averageOfLevelsRecursive(TreeNode root)
    {
        List<Double> result = new ArrayList<>();

        if (root == null) return result;

        List<List<Integer>> list = new ArrayList<>();

        helper(root, 0, list);

        for (int i=0; i<list.size(); i++)
        {
            double sum = 0.0;

            List<Integer> curList = list.get(i);

            for (Integer num: curList)
            {
                sum += num;
            }
            result.add(sum / curList.size());
        }
        return result;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> list)
    {
        if (node == null) return;

        if (level >= list.size())
        {
            list.add(new ArrayList<>());
        }
        list.get(level++).add(node.val);

        helper(node.left, level, list);

        helper(node.right, level, list);
    }

    private List<Double> averageOfLevelsIterative(TreeNode root)
    {
        List<Double> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            double sum = 0.0;

            for (int i=0; i<size; i++)
            {
                TreeNode node = queue.poll();

                sum += node.val;

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
            result.add(sum / size);
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
