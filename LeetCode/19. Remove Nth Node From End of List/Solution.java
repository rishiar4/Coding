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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if( head == null || n == 0 )
          return head;
        
        ListNode c1 = head;
        ListNode c2 = head;

        while( n > 0 )
        {
            c1 = c1.next;
            n--;
        }
        
        if( c1 == null )
        {
            return head.next;
        }

        while( c1.next != null )
        {
            c1 = c1.next;
            c2 = c2.next;
        }

       

        c2.next = c2.next.next;

        return head;

    }
}