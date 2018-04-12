package Apr11;

public class ReverseLinkedListII92
{
    public ReverseLinkedListII92() { }

    private ListNode reverseBetween(ListNode head, int m, int n)
    {
        ListNode dummyNode = new ListNode(0), preNode = dummyNode;

        dummyNode.next = head;

        for (int i = 1; i < m; i++) {
            preNode = preNode.next;
        }
        ListNode curNode = preNode.next, nextNode = curNode.next;

        for (int i = 1; i <= n - m; i++) {
            curNode.next = nextNode.next;

            nextNode.next = preNode.next;

            preNode.next = nextNode;

            nextNode = curNode.next;
        }
        return dummyNode.next;
    }

    private class ListNode
    {
        int val;

        ListNode next;

        ListNode(int val) { this.val = val; }
    }
}
