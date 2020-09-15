public class Solution{

    public ListNode segerateEvenOdd( ListNode head )
    {
        if( head == null || head.next == null ) 
            return head;
        
        ListNode even = new ListNode(-1);
        ListNode ep = even;

        ListNode odd = new ListNode(-1);
        ListNode op = odd;

        ListNode curr = head;

        while( curr != null )
        {
            if( curr.val % 2 == 0 )
            {
                ep.next = curr;
                ep = ep.next;
            }
            else
            {
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }

        ep.next = odd.next;
        return even.next;
    }
}