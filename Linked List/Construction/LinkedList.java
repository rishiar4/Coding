public class LinkedList{
    
    public class Node{
        int data = 0;
        Node next = null;
        
        Node( int data )
        {
            this.data = data;
        }
    }

    protected Node head = null;
    protected Node tail = null;
    protected int elements = 0;

    public int size()
    {
        return this.elements;
    }

    public boolean isEmpty()
    {
        return this.elements == 0; 
    }

    public void increaseSize()
    {
        this.elements++;
    }

    public void decreaseSize()
    {
        this.elements--;
    }

    // ==================== Add First ========================
    protected void addNodeFirst( Node node )
    {
        if( this.elements == 0 )
        {
            this.head = node;
            this.tail = node;
        }
        else
        {
            node.next = this.head;
            this.head = node;
        }
        increaseSize();
    }

    public void addFirst( int val )
    {
        Node node = new Node(val);
        addNodeFirst( node );
    }

    // ===================== Add At ===============================

    protected void addNodeAt( int idx, Node node )
    {
        if( idx == 0 ) addNodeFirst( node );
        else if( idx == this.elements ) addNodeLast( node );
        else
        {
            Node nn = getNodeAt( idx - 1 );
            Node nextNode = nn.next;
            nn.next = node;
            node.next = nextNode; 
        }

        increaseSize();
    }

    public void addAt( int idx, int val ) throws Exception
    {
        if( idx < 0 || idx > this.elements )
        {
            throw new Exception("Null Pointer Exception");
        }
        Node node = new Node( val );
        addNodeAt( idx, node );
    }

    // ===================== Add Last ============================

    protected void addNodeLast( Node node )
    {
        if( this.elements == 0 )
        {
            this.head = node;
            this.tail = node;
        }
        else
        {
            this.tail.next = node;
            this.tail = node;
        }
        increaseSize();
    }
    public void addLast( int val )
    {
        Node node = new Node( val );
        addNodeLast( node );
    }

    // =================== Get First ======================

    protected Node getNodeFirst(){
        return this.head;
    }

    public int getFirst() throws Exception{
        if(this.elements == 0){
            throw new Exception("NullPointerException: -1");
        }

        Node node = getNodeFirst();
        return node.data;
    }

    // ============================= Get At =============================

    protected Node getNodeAt( int idx )
    {
        Node temp = this.head;
        while( idx > 0 )
            {
                temp = temp.next;
                idx--;
            }
        return temp;
    }
    public int getAt( int idx ) throws Exception
    {
        if( this.elements == 0 )
        {
            throw new Exception("NullPointerException");
        }
        else
        {
            Node node =  getNodeAt( idx );
            return node.data;
        }
    }

    // ============================ Get Last ======================

    protected Node getLastNode()
    {
        return this.tail;
    }

    public int getLast() throws Exception
    {
        if( this.elements == 0 )
        {
            throw new Exception("Null Pointer Exception");
        }
        else
        {
            Node node = getLastNode();
            return node.data;
        }
    }

    // ============================= Remove First ===================

    protected Node removeFirstNode()
    {
        Node nn =this.head;
        this.head = this.head.next;
        decreaseSize();
        return nn;
    }
    public int removeFirst() throws Exception
    {
        if( this.elements == 0 )
        {
            throw new Exception("Null Pointer Exception");
        }
        else
        {
            Node node = removeFirstNode();
            return node.data;
        }

    }

    // =========================== remove At =====================

    protected Node removeNodeAt( int idx )
    {
        if( idx == 0 ) return removeFirstNode();
        else if( this.elements == idx ) return removeLastNode();
        else
        {
            Node prev = getNodeAt( idx - 1 );
            Node nn = prev.next;
            prev.next = nn.next;
            nn.next = null;
            decreaseSize();
            return nn;
        }
    }
    public int removeAt( int idx ) throws Exception
    {
        if( idx < 0 || idx > this.elements )
        {
            throw new Exception("Null Pointer Exception");
        }
        Node node = removeNodeAt( idx );
        return node.data;
    }

    // ============================ remove Last =====================

    protected Node removeLastNode()
    {
        Node nn = this.tail;
        if( this.elements == 1 )
        {
            this.head = null;
            this.tail = null;
        }
        else
        {
            Node prev = getNodeAt( this.elements - 2 );
            prev.next = null;
            this.tail = prev;
        }
        decreaseSize();
        return nn;
    }

    public int removeLast() throws Exception
    {
        if( this.elements == 0 )
        {
            throw new Exception("Null Pointer Exception");
        }
        else
        {
            Node node = removeLastNode();
            return node.data;
        }
    }

    // ============================ Display ==========================

    @Override
    public String toString()
    {
        Node temp = this.head;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while( temp != null )
        {
            sb.append(temp.data);
            if( temp.next != null )
            {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}