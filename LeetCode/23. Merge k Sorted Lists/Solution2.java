class Solution {

    public ListNode mergeLists( ListNode l1, ListNode l2 )
    { 
        if( l1 == null || l2 == null )
        {
            return ( l1 == null ) ? l2 : l1;
        }

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

    public ListNode mergeKLists( ListNode[] lists, int si, int ei )
    {
        if( si == ei ) return lists[si];

        int mid = ei + ( si - ei ) / 2;

        return mergeLists( mergeKLists(lists, si, mid ) , mergeKLists( lists, mid + 1, ei ) );
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if( lists.length == 0 ) return null;

        return mergeKLists( lists, 0, lists.length - 1 );
        
    }
}