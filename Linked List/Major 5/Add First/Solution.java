public class Solution{

    public void addFirst( Node node )
    {
        if( head == null )
        {
            head = node;
            tail = node;
        }
        else
        {
            node.next = head;
            head = head.next;
        }
    }
}