class StepByStepDirectionsFromABinaryTreeNodetoAnother2096 {
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPathBuilder = new StringBuilder();
        StringBuilder endPathBuilder = new StringBuilder();

        findPath(root, startValue, startPathBuilder);
        findPath(root, destValue, endPathBuilder);

        int len = Math.min(startPathBuilder.length(), endPathBuilder.length());
        // Find out LCA
        int index = 0;
        while (index < len && startPathBuilder.charAt(index) == endPathBuilder.charAt(index)) {
            index++;
        }

        String startString = startPathBuilder.substring(index);
        String endString = endPathBuilder.substring(index);

        if (startString == null || startString.length() == 0) {
            return endString;
        }

        StringBuilder upPathBuilder = new StringBuilder();
        for (int i=0; i<startString.length(); ++i) {
            upPathBuilder.append("U");
        }
        return upPathBuilder.append(endString).toString();
    }

    private boolean findPath(TreeNode root, int val, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        // Found
        if (root.val == val) {
            return true;
        }

        int size = sb.length();
        
        sb.append("L");
        boolean isLeft = findPath(root.left, val, sb);
        if (isLeft) {
            return true;
        }
        
        // resize --> back to the LCA point 
        sb.setLength(size);
        sb.append("R");
        boolean isRight = findPath(root.right, val, sb);
        if (isRight) {
            return true;
        }
        return isRight;
    }
    public static void main(String[] args) {
        // // Test 1
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(3);

        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(4);

        // int startValue = 3;
        // int destValue = 6;
        // // expected "UURL"

        // Test 2
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        int startValue = 2;
        int destValue = 1;
        // expected "L"

        System.out.println(new StepByStepDirectionsFromABinaryTreeNodetoAnother2096().getDirections(root, startValue, destValue));
    }
}

