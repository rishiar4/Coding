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
    public int length( ListNode head )
    {
        int count = 0;
        while( head != null )
        {
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || head.next == null || k == 0 ) 
            return head;
        
        ListNode curr = head;
        int len = length( curr );
        k = k % len;
        
        if( k == 0 ) return head;

        ListNode c1 = head;
        ListNode c2 = head;

        while( k > 0 )
        {
            c1 = c1.next;
            k--;
        }

        while( c1.next != null )
        {
            c2 = c2.next;
            c1 = c1.next;
        }

        c1.next = head;
        head = c2.next;
        c2.next = null;

        return head;
    }
}