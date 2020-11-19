public class LinkedList{
    public class Node{
        int data = 0;
        Node next = null;

        Node( int data ){
            this.data = data;
            this.next = null;
        }
    }

    private int elementCount = 0;
    private Node head = null;
    private Node tail = null;

    // Basic

    public int size(){
        return this.elementCount;
    }

    public boolean isEmpty(){
        return this.elementCount == 0;
    }

    @Override
    public String toString(){
        Node curr = this.head;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while( curr != null ){
            sb.append( curr.data + " ");
            if( curr.next != null ) sb.append(", ");
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    // Add

    // addFirst
    protected void addFirstNode( Node node ){
        if( this.head == null ){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    public void addFirst( int data ){
        Node node = new Node( data );
        addFirstNode( node );
        this.elementCount++;
    }

    // addAt
    protected void addAtNode( Node node, int idx ){
        Node curr = this.head;
        for( int i = 0; i < idx - 1; i++ ){
            curr = curr.next;
        }
        Node nextNode = curr.next;
        curr.next = node;
        node.next = nextNode;
    }
    public void addAt( int data, int idx ) throws Exception{
        if( idx < 0 || idx > this.elementCount ){
            throw new Exception("Index out of Bounds: -1");
        }
        Node node = new Node( data );
        addAtNode( node, idx );
        this.elementCount++;
    }

    // addLast
    protected void addLastNode( Node node ){
        if( this.head == null ){
            this.head = null;
            this.tail = null;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
    }
    public void addLast( int data ){
        Node node = new Node( data );
        addLastNode( node );
        this.elementCount++;
    }

    // Remove
    
    // removeFirst
    protected Node removeFirstNode(){
        Node node = this.head;
        if( this.elementCount == 1 ){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.next;
            node.next = null;
        }
        return node;
    }
    public int removeFirst() throws Exception{
        if( this.elementCount == 0 ){
            throw new Exception("Null Pointer Exception: -1");
        }
        Node rv = removeFirstNode();
        this.elementCount--;
        int data = rv.data;
        return data;
    }

    //removeLast
    protected Node removeLastNode(){
        Node node = this.tail;
        Node curr = this.head;
        Node prev = null;
        while( curr.next != null ){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        this.tail = prev;
        return node;
    }
    public int removeLast() throws Exception{
        if( this.elementCount == 0 ){
            throw new Exception("Null Pointer Exception: -1");
        }else{
            Node rv = removeLastNode();
            this.elementCount--;
            int data = rv.data;
            return data;
        }
    }

    // removeAt
    protected Node removeAtNode( int idx ){
        if( idx == 0 ) return removeFirstNode();
        else if( idx == this.elementCount ) return removeLastNode();
        else{
            Node prev = getAtNode( idx - 1 );
            Node curr = prev.next;
            
            prev.next = curr.next;
            curr.next = null;

            return curr;
        }
    }
    public int removeAt( int idx ) throws Exception{
        if( idx < 0 || idx > this.elementCount ){
            throw new Exception("Index out of Bounds: -1");
        }
        Node node = removeAtNode( idx );
        this.elementCount--;
        int data = node.data;
        return data;
    }

    // Get

    // getFirst
    protected Node getFirstNode(){
        return this.head;
    }
    public int getFirst() throws Exception{
        if( this.elementCount == 0 ){
            throw new Exception("Null Pointer Exception: -1");
        }
        Node rv = getFirstNode();
        int data = rv.data;
        return data;
    }

    // getAt
    protected Node getAtNode( int idx ){
        Node curr = this.head;
        for( int i = 0; i < idx ; i++ ){
            curr = curr.next;
        }
        return curr;
    }
    public int getAt( int idx ) throws Exception{
        if( idx < 0 || idx > this.elementCount ){
            throw new Exception("Index out of Bounds: -1");
        }
        Node rv = getAtNode( idx );
        int data = rv.data;
        return data;
    }


    // getLast
    protected Node getLastNode(){
        return this.tail;
    }
    public int getLast() throws Exception{
        if( this.elementCount == 0 ){
            throw new Exception("Null Pointer Exception: -1");
        }
        Node rv = getLastNode();
        int data = rv.data;
        return data;
    }

}