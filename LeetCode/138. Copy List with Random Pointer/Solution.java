/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public void copyNode( Node head )
    {
        Node curr = head;
        while( curr != null )
        {
            Node next = curr.next;
            Node nn = new Node( curr.val );

            curr.next = nn;
            nn.next = next;

            curr = next;
        }
    }

    void copyRandomPointers( Node head )
    {
        Node curr = head;

        while( curr != null )
        {
            if( curr.random != null )
            {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }
    }

    Node extractMyLL( Node head )
    {
        Node dummy = new Node(-1);
        Node prev = dummy;

        Node curr = head;
        while( curr != null )
        {
            prev.next = curr.next;
            curr.next = curr.next.next;

            prev = prev.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        if( head == null )
             return head;
            
        copyNode( head );
        copyRandomPointers( head );
        return extractMyLL( head );
    }
}