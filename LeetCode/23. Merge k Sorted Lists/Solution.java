import java.util.PriorityQueue;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists.length == 0  ) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> {
           return a.val - b.val;
        });
       
        
        for( int i = 0; i < lists.length; i++ )
        {
            if(lists[i] != null )  pq.add( lists[i] );
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while( pq.size() != 0  )
        {
            ListNode node = pq.remove();
            
            ListNode nextNode = node.next;
            node.next = null;

            if( nextNode != null ) pq.add( nextNode );

            prev.next = node;
            prev = node; 

        }

        return dummy.next;
    }
}



