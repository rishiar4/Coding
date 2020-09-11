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

    public ListNode reverseList(ListNode head) {
        
        if( head == null || head.next == null )
        {
            return head;
        }
        
        ListNode curr = head;
        ListNode prev = null;
        
        while( curr != null )
        {
            ListNode forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public ListNode middleNode2(ListNode head) {
        if( head == null || head.next == null )
        {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while( fast.next!= null && fast.next.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; 
    }
    public void reorderList(ListNode head) {
        if( head == null || head.next == null )
        {
            return;
        }

        ListNode midHead = middleNode2( head );

        ListNode tHead = midHead.next;
        midHead.next = null;
        
        tHead = reverseList( tHead );


        ListNode c1 = head;
        ListNode c2 = tHead;

        while( c1 != null && c2 != null )
        {

            ListNode temp1 = c1.next;
            ListNode temp2 = c2.next;
            
            c1.next = c2;
            c2.next = temp1;
            c2 = temp2;
            c1 = c1.next.next;
        }
        
        // c1.next = c2;
        
    }
}