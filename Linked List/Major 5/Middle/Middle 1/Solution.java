public class Solution{

    public Node middle_01( Node head )
    {
        if( head == null || head.next == null )
        {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while( fast != null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}