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
    public ListNode oddEvenList(ListNode head) {
        if( head == null || head.next == null ) return head;
        
        int cnt = 0;
        ListNode curr = head;
        
        ListNode even = new ListNode(-1);
        ListNode ep = even;
        
        ListNode odd = new  ListNode(-1);
        ListNode op = odd;
        
        while( curr != null )
        {
            if( cnt == 0 )
            {
                op.next = curr;
                op = op.next;
            }
            else
            {
                ep.next = curr;
                ep = ep.next;
            }
            curr = curr.next;
            cnt = ( cnt + 1 ) % 2;
        }
        op.next = even.next;
        ep.next = null;
        
        return odd.next;
    }
}