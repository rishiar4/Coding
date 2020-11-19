public class questions{
   
    // 876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        if( head == null || head.next == null ){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode middleNode2( ListNode head ){
        if( head == null || head.next == null ){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 206. Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null ){
            return head;
        }   
        
        ListNode curr = head;
        ListNode prev = head;

        while( curr != null ){
            ListNode fwd = curr.next;

            curr.next = prev;
            prev = curr;

            curr = fwd;
        }
    }




    


}