package Apr4;

public class RotateList61
{
    public RotateList61()
    {

    }

    public ListNode rotateRight(ListNode head, int k)
    {
        if (head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(0), fast = fakeHead, slow = fakeHead;

        fakeHead.next = head;

        int len = 0;

        while (fast.next != null)
        {
            fast = fast.next;

            len++;
        }
        for (int i=len - k % len; i>0; i--)
        {
            slow = slow.next;
        }
        fast.next = fakeHead.next;

        fakeHead.next = slow.next;

        slow.next = null;

        return fakeHead.next;
    }

    private class ListNode
    {
        int val;

        ListNode next;

        ListNode(int x) { val = x; }
    }
}
