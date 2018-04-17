package Apr16;

import Apr12.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal314
{
    TreeNode root;

    int min, max;

    public BinaryTreeVerticalOrderTraversal314()
    {
        min = 0;

        max = 0;

        root = buildTree();

        System.out.println(verticalOrder(root));
    }

    private List<List<Integer>> verticalOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Map<Integer, List<Integer>> map = generateMap(root);

        for (int i=min; i<=max; i++)
        {
            List<Integer> list = map.get(i);

            result.add(list);
        }
        return result;
    }

    private Map<Integer, List<Integer>> generateMap(TreeNode node)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();

        Queue<Integer> indexes = new LinkedList<>();

        queue.add(node);

        indexes.add(0);

        while (!queue.isEmpty())
        {
            TreeNode cur = queue.remove();

            int index = indexes.remove();

            if (!map.containsKey(index))
            {
                map.put(index, new LinkedList<>());
            }
            map.get(index).add(cur.val);

            if (cur.left != null)
            {
                queue.add(cur.left);

                indexes.add(index -1);

                min = Math.min(min, index -1);
            }
            if (cur.right != null)
            {
                queue.add(cur.right);

                indexes.add(index + 1);

                max = Math.max(max, index + 1);
            }
        }
        return map;
    }

    private TreeNode buildTree()
    {
        TreeNode root = new TreeNode(3), cur = root;

        cur.left = new TreeNode(9);

        cur.right = new TreeNode(8);

        cur = root.left;

        cur.left = new TreeNode(4);

        cur.right = new TreeNode(0);

        cur = root.right;

        cur.left = new TreeNode(1);

        cur.right = new TreeNode(7);

        return root;
    }
}
