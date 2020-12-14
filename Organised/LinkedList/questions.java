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

    // 23. Merge k Sorted Lists
    public ListNode mergeTwoLists( ListNode l1, ListNode l2 ){
        if( l1 == null || l2 == null ) return ( l1 == null ) ? l2 : l1;

        ListNode c1 = l1;
        ListNode c2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

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
        prev.next = ( c2 != null ) ? c2 : c1;

        return dummy.next;
    }
    public ListNode mergeKLists( ListNode[] lists, int si, int ei ){
        if( si == ei ) return lists[si];
        
        int mid = ( si + ei )/2;
        return mergeTwoLists( mergeKLists( lists, si, mid ), mergeKLists( lists, mid + 1, ei ) );
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists.length == 0 ) return null;
        
        return mergeKLists( lists, 0, lists.length - 1 );
    }

    // 23. Merge k Sorted Lists Approach 2
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> {
            return a.val - b.val;
        });

        for( int i = 0 ; i < lists.length; i++ ){
            pq.add( lists[i] );
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        if( pq.size() == 0 ) return null;
        while( pq.size() != 1 ){

            ListNode node = pq.remove();

            ListNode next = node.next;
            node.next = null;
            
            prev.next = node;

            prev = node;
            
            if( next != null ) 
                pq.add( next );
            
        }

        prev.next = qu.remove();

        return dummy.next;
    }

    // 25. Reverse Nodes in k-Group
    ListNode th = null;
    ListNode tt = null;
    public int length( ListNode head ){
        ListNode curr = head;
        int l = 0;
        while( curr != null ){
            l++;
            curr = curr.next;
        }
        return l;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if( head == null || head.next == null || k <= 1 ) return head;

        int l = length( head );
        if( l < k ) return head;

        ListNode curr = head;

        ListNode oH = null;
        ListNode oT = null;

        while( curr != null && l >= k ){
            int K = k;
            while( K > 0 ){

                K--;
                ListNode next = curr.next;
                curr.next = null;

                addFirst( curr );

                curr = next;
            }

            if( oH == null ) {
                oH = th;
                oT = tt;
            }else{
                oT.next = th;
                oT = tt;
            }
            
            tt = null;
            th = null;

            l -= k;
            K = k;
        }
        oT.next = curr;
        return oH;
    }

    // 92. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( head == null || head.next == null || n == m ) return head;

        ListNode curr = head;
        ListNode prev = null;

        int idx = 1;
        while( curr != null ){
            while( idx >= m && idx <= n ){
                ListNode next = curr.next;
                curr.next = null;

                addFirst( curr );
                curr = next;
                idx++;
            }
        }
    }

    // 138. Copy List with Random Pointer
    public void copyNodes( Node head ){
        Node curr = head;
        while( curr != null ){
            Node next = curr.next;
            Node node = new Node( curr.val );

            node.next = next;
            curr.next = node;

            curr = next;
        }
    }

    public void copyRandoms( Node node ){
        Node curr = node;

        while( curr != null ){
            if( curr.random != null ){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
    }

    public Node extractLL( Node head ){
        Node dummy = new Node( -1 );
        Node prev = dummy;

        Node curr = head;

        while( curr != null ){
            prev.next = curr.next;
            curr.next = curr.next.next;

            prev = prev.next;

            curr = curr.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if( head == null ) return head;
        
        copyNodes( head );
        copyRandoms( head );
        return extractLL( head );
    }


    // 146. LRU Cache

    class LRUCache {

        private class Node{
            Integer key = 0;
            Integer value = 0;

            Node prev = null;
            Node next = null;

            Node( Integer key, Integer value ){
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer,Node> map = new HashMap<>();
        private Node head;
        private Node tail;
        private int maxCapacity = 0;
        private int size = 0;


        public LRUCache(int capacity) {
            this.maxCapacity = capacity;
        }
        
        public int get(int key) {
            if( !map.containsKey(key) ) return -1;

            Node node = map.get( key );
            shiftToFirst( node );

            return node.value;
        }

        private void addFirst( Node node ){
            if( this.size == 0 ){
                this.head = node;
                this.tail = node;
            }else{
                this.head.next = node;
                node.prev = this.head;
                this.head = node;
            }
            this.size++;
        }

        private void removeNode( Node node ){
            if( this.size == 1 ){
                this.head = null;
                this.tail = null;
            }else if( this.tail == node ){
                Node nextNode = this.tail.next;
                this.tail.null;
                nextNode.prev = null;
                this.tail = nextNode;
            }else{
                Node prevNode = node.prev;
                Node nextNode = node.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;

                node.prev = null;
                node.next = null;
            }
            this.size--;
        }

        private void shiftToFirst( Node node ){
            if( this.head == node ) return;

            removeNode( node );
            addFirst( node );
        }
        
        public void put(int key, int value) {
            if( map.containsKey(key) ){
                Node node = map.get(key);
                node.value = value;
                shiftToFirst( node );
            }else{
                Node node = new Node( key, value );
                addFirst( node );
                map.put( key.node );

                if( this.size > this.capacity ){
                    Node lastNode = this.tail;
                    removeNode( lastNode );
                    map.remove( lastNode.key );
                }
            }
        }
    }
    

}