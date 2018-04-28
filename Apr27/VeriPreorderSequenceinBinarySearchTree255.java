package Apr27;

import java.util.Stack;

public class VeriPreorderSequenceinBinarySearchTree255
{
    public VeriPreorderSequenceinBinarySearchTree255()
    {
        int[] preorder = {20, 10, 5, 40, 30, 35, 45};

        System.out.println(verifyPreorder(preorder));
    }

    private boolean verifyPreorder(int[] preorder)
    {
        if (preorder == null || preorder.length == 0) return true;

        Stack<Integer> stack = new Stack<>();

        int min = Integer.MIN_VALUE;

        for (int num: preorder)
        {   // Check right (num) > mid / left (min)
            if (num < min)
                return false;

            while (!stack.isEmpty() && num > stack.peek())
            {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
