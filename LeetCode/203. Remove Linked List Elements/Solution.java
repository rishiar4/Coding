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
    public ListNode removeElements(ListNode head, int val) {
    
        if( head == null )  return head;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        ListNode curr = head;
        
        while( curr != null )
        {
            if( curr.val != val )
            {
                p.next = curr;
                p = p.next;
            }
            
            curr = curr.next;
        }
        p.next = null;
        return dummy.next;
    }
}