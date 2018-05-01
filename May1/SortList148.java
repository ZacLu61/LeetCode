package May1;

public class SortList148
{
    public SortList148() { }

    /**
     * Merge sort
     *
     * @param head
     * @return
     */
    private ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null) return head;

        ListNode fast = head, slow = head, pre = null;

        while (fast != null && fast.next != null)
        {
            pre = slow;

            fast = fast.next.next;

            slow = slow.next;
        }
        pre.next = null;

        ListNode node1 = sortList(head);

        ListNode node2 = sortList(slow);

        return merge(node1, node2);
    }

    /**
     * Merge
     *
     * @param node1
     * @param node2
     * @return
     */
    private ListNode merge(ListNode node1, ListNode node2)
    {
        if (node1 == null) return node2;

        if (node2 == null) return node1;

        if (node1.val < node2.val)
        {
            node1.next = merge(node1.next, node2);

            return node1;
        }
        else
        {
            node2.next = merge(node1, node2.next);

            return node2;
        }
    }
}
