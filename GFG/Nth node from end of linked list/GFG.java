class GfG
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    public int getNthFromLast(Node head, int n){
        Node first = head, second = head;
        int i = 0;
        while( i < n - 1 && first != null )
        {
            first = first.next;
            i++;
        }
        if( first == null ) return -1;
        
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }
}