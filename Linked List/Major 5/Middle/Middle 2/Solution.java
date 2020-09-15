public class Solution{

    public Node middle_02( Node head )
    {
        if( head == null || head.next == null )
        {
            return head;
        }
        Node slow = head;
        Node fast = head;

        while( fast.next != null && fast.next.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}