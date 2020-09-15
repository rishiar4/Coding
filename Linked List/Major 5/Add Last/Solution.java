public class Solution{
    public void addLast( Node node )
    {
        if( head == null )
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }
}