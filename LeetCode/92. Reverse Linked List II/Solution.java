/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode tH = null;
    ListNode tT = null;

    public void addFirst( ListNode node )
    {
        if( tH == null )
        {
            tH = node;
            tT = node;
        }
        else
        {
            node.next = tH;
            tH = node;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( head == null || head.next == null || m == n )
        {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        int idx = 1;
        while( curr != null )
        {
            while( idx >= m && idx <= n )
            {
                idx++;
                ListNode fwd = curr.next;
                curr.next = null;

                addFirst( curr );

                curr = fwd;

            }

            if (idx > n)
        {
            if (prev == null)
                head = tH;
            else
                prev.next = tH;

            tT.next = curr;
            break;
        }
            prev = curr;
            curr = curr.next;
            idx++;
        }
        return head;
    }
}