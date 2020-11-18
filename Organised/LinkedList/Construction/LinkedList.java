public class LinkedList{
    protected class Node{
        int data = 0;
        Node next = null;

        Node( int data ){
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    int elementCount = 0;

    // Basic Functions

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

    // AddFirst
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

    // Remove

    // RemoveFirst
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
            throw new Exception("Null Pointer Exception: -1 ");
        }else{
            Node rv = removeFirstNode();
            this.elementCount--;
            int rData = rv.data;
            return rData;
        }
    }


    // Get
    
    // getFirst
    protected Node getFirstNode(){
        return this.head;
    }

    public int getFirst() throws Exception{
        if( this.elementCount == 0 ){
            throw new Exception("Null Pointer Exception: -1");
        }else{
            Node rv = getFirstNode();
            int data = rv.data;
            return data;
        }
    }
}