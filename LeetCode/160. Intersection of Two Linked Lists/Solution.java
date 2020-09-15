/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getCycleNode( ListNode head )
    {
        if( head == null || head.next == null )
            return null;
    
        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;

            if( fast == slow )
               break;
        }

        if( fast != slow )
        {
            return null;
        }

        slow = head;

        while( slow != fast )
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headA == null ) 
            return null;
        
        ListNode curr = headA;
        ListNode prev = null;

        while( curr != null )
        { 
            prev = curr;
            curr = curr.next;
        }

        prev.next = headB;

        ListNode ans = getCycleNode( headA );

        prev.next = null;

        return ans;
    }
}