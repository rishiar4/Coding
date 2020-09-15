public class Solution{
    public Node reverseLL( Node head )
    {
        if( head == null || head.next == null )
        {
            return head;
        }
        
        Node curr = head;
        Node prev = null;

        while( curr != null )
        {
            Node fwd = curr.next;

            curr.next = prev;
            prev = curr;

            curr = fwd;
        }

        return prev;
    }
}