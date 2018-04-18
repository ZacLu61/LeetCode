package Apr17;

import Apr12.TreeNode;

public class ConvertSortedListtoBinarySearchTree109
{
    public ConvertSortedListtoBinarySearchTree109() { }

    private TreeNode sortedListToBST(ListNode head)
    {
        if (head == null) return null;

        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail)
    {
        if (head == null || head == tail) return null;

        if (head.next == tail) return new TreeNode(head.val);

        ListNode fast = head, slow = head;

        while (fast != tail && fast.next != tail)
        {
            fast = fast.next.next;

            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);

        root.left = helper(head, slow);

        root.right = helper(slow.next, tail);

        return root;
    }

    public class ListNode
    {
        public int val;

        public ListNode next;

        public ListNode(int val) { this.val = val; }
    }
}
