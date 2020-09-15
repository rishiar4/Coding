public class Solution{

    public Node mergeLL( Node l1, Node l2 )
    {
        if( l1 == null || l2 == null )
        {
            return ( l1 == null ) ? l2 : l1; 
        }

        Node dummy = new Node(-1);
        Node prev = dummy;
        Node c1 = l1;
        Node c2 = l2;

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

        if( c1 == null ) 
            prev.next = c2;
        else
            prev.next = c1;
            
        return dummy.next;
    }
}