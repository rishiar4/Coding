class Solution {
    
    public ListNode middleNode( ListNode head )
    {
        if( head == null || head.next == null  ) return head;

        ListNode fast = head;
        ListNode slow = head;

        while( fast.next != null && fast.next.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    
    public ListNode mergeLists( ListNode l1, ListNode l2 ){
        if( l1 == null || l2 == null )
          return ( l1 == null ) ? l2 : l1;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode c1 = l1;
        ListNode c2 = l2;

        while( c1 != null && c2 != null )
        {
            if( c1.val < c2.val )
            {
                prev.next = c1;
                c1 = c1.next;
            }
            else
            {
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        if( c1 == null ) prev.next = c2;
        else prev.next = c1;

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null ) return head;

        ListNode midHead = middleNode( head );
        ListNode tHead = midHead.next;
        midHead.next = null;

        return mergeLists( sortList( head), sortList( tHead ) );
    }

}