public class questions{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        if( head == null || head.next == null ){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode2( ListNode head ){
        if( head == null || head.next == null ) return head;

        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 206. Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null ) return head;

        ListNode curr = head;
        ListNode prev = null;

        while( curr != null ){
            ListNode fwd = curr.next;

            curr.next = prev;
            prev = curr;

            curr = fwd;
        }
        return prev;
    }

    // 234. Palindrome Linked List
    public ListNode middleNode( ListNode head ){
        if( head == null || head.next == null ) return head;

        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverseList( ListNode head ){
        if( head == null || head.next == null ) return head;

        ListNode curr = head;
        ListNode prev = null;

        while( curr != null ){
            ListNode fwd = curr.next;

            curr.next = prev;
            prev = curr;

            curr = fwd;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null ) return head;

        ListNode midHead = middleNode( head );
        ListNode tHead = midHead.next;
        midHead.next = null;

        tHead = reverseList( tHead );

        ListNode c1 = head;
        ListNode c2 = tHead;
        
        boolean res = true;
        while( c1 != null && c2 != null ){
            if( c1.val != c2.val ){
                res = false;
                break;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        tHead = reverseList( tHead );
        midHead.next = tHead;

        return res;
    }

    // 143. Reorder List
    public ListNode middleNode( ListNode head ){
        if( head == null || head.next == null ) return head;

        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList( ListNode head ){
        if( head == null || head.next == null ) return head;

        ListNode curr = head;
        ListNode prev = null;

        while( curr != null ){
            ListNode fwd = curr.next;

            curr.next = prev;
            prev = curr;

            curr = fwd;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if( head == null || head.next == null ) return;

        ListNode midHead = middleNode( head );
        ListNode tHead = midHead.next;
        midHead.next = null;
        
        tHead = reverseList( tHead );

        ListNode c1 = head;
        ListNode c2 = tHead;

        while( c1 != null && c2 != null ){
            ListNode f1 = c1.next;
            ListNode f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }

    // reverse of Order List
    public ListNode th1 = null;
    public ListNode tt1 = null;
    public ListNode th2 = null;
    public ListNode th2 = null;

    public void addLast( ListNode node ){
        if( th1 == null ){
            th1 = node;
            tt1 = node;
        }else{
            tt1.next = node;
            tt1 = node;
        }
    }

    public void addFirst( ListNode node ){
        if( th2 == null ){
            th2 = node;
            tt2 = node;
        }else{
            node.next = th2;
            th2 = node;
        }
    }

    public ListNode orderList( ListNode head ){
        if( head == null || head.next == null ) return head;

        int cnt = 0;
        ListNode curr = head;
        while( curr != null ){
            ListNode fwd = curr.next;
            curr.next = null;

            if( cnt == 0 )
                addLast( curr );
            else
                addFirst( curr );

            cnt = ( cnt + 1 ) % 2;
            curr = fwd;
        }
        tt1.next = th1;
        return th1;
    }

    // 21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null || l2 == null ) return ( l1 == null ) ? l2 : l1;   
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode c1 = l1;
        ListNode c2 = l2;

        while( c1 != null && c2 != null ){
            if( c1.val < c2.val ){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.nextl
        }

        prev.next = ( c1 == null ) ? c2 : c1;

        return dummy.next;
    }
    
    // 148. Sort List
    public ListNode middleNode( ListNode head ){
        if( head == null || head.next == null ) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists( ListNode l1, ListNode l2 ){
        if( l1 == null || l2 == null )
            return ( l1 == null ) ? l2 : l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode c1 = l1;
        ListNode c2 = l2;

        while( c1 != null && c2 != null ){
            if( c1.val < c2.val ){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = ( c1 == null ) ? c2 : c1;

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null ) return head;

        ListNode midHead = middleNode( head );
        ListNode tHead = midHead.next;
        midHead.next = null;

        return mergeTwoLists( sortList( head ), sortList( tHead ) );
    }
}