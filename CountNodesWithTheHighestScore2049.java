class CountNodesWithTheHighestScore2049 {
    public int countHighestScoreNodes(int[] parents) {
        if (parents == null || parents.length == 0) {
            return 0;
        }

        int len = parents.length;
        // Build tree
        TreeNode[] tree = new TreeNode[len];
        for (int i=0; i<len; ++i) {
            tree[i] = new TreeNode(i);
        }
        for (int i=1; i<len; ++i) {
            TreeNode child = tree[i];
            TreeNode parent = tree[parents[i]];
            // pre-order
            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // max, count
        long[] result = new long[2];
        // Compute count sub-tree nodes
        dfs(tree[0], len, result);
        return (int) result[1];
    }

    private long dfs(TreeNode node, int len, long[] result) {
        if (node == null) {
            return 0;
        }
        long left = dfs(node.left, len, result);
        long right = dfs(node.right, len, result);
        long subTreeNodeCount = 1 + left + right;
        long restCount = len - subTreeNodeCount;

        long currentResult = 1;
        if (left != 0) {
            currentResult *= left;
        }
        if (right != 0) {
            currentResult *= right;
        }
        if (restCount != 0) {
            currentResult *= restCount;
        }
        
        // [maxSubTree multiple, count]
        if (currentResult > result[0]) {
            result[0] = currentResult;
            result[1] = 1;
        } else if (currentResult == result[0]) {
            result[1]++;
        }
        return subTreeNodeCount;
    }

    public static void main(String[] args) {
        // // Test 1
        // int[] parents = {-1, 2, 0, 2, 0}; // expect 3
        
        // Test 2 
        int[] parents = {-1, 2, 0}; // expect 2


        System.out.println(new CountNodesWithTheHighestScore2049().countHighestScoreNodes(parents));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}