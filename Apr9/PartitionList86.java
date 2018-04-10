package Apr9;

public class PartitionList86
{
    public PartitionList86() { }

    private ListNode partition(ListNode head, int x)
    {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0), small = dummy1, big = dummy2, cur = head;

        while (cur != null)
        {
            if (cur.val < x)
            {
                small.next = cur;

                small = small.next;
            }
            else
            {
                big.next = cur;

                big = big.next;
            }
            cur = cur.next;
        }
        big.next = null;

        small.next = dummy2.next;

        return dummy1.next;
    }

    private class ListNode
    {
        int val;

        ListNode next;

        private ListNode(int val) { this.val = val; }
    }
}
