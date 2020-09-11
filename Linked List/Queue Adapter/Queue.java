public class Queue{
    
    public class Node{
        int data;
        Node next;

        Node( int data )
        {
            this.data = data;
        }
    }

    protected Node head = null;
    protected Node tail = null;
    protected int size = 0;

    protected void increaseSize()
    {
        this.size++;
    }

    protected  void decreaseSize()
    {
        this.size--;
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    protected void nodeAdd( Node node )
    {
        if( this.head == null )
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

    public void add( int data )
    {
        Node node = new Node( data );
        nodeAdd( node );
    }

    protected Node peekNode()
    {
        return this.head;
    }

    public int peek() throws Exception
    {
        if( this.size == 0 )
        {
            throw new Exception("Null Pointer Exception");
        }
        else
        {
            Node rNode = peekNode();
            return rNode.data;
        }
    }

    protected Node nodeRemove()
    {
        Node rNode = this.head;
        this.head = this.head.next;
        decreaseSize();
        return rNode;
    }

    public int remove() throws Exception
    {
        if( this.size == 0 )
        {
            throw new Exception("Null Pointer Exception");
        }
        else
        {
            Node rNode = nodeRemove();
            return rNode.data;
        }
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node temp = this.head;
        while( temp != null )
        {
            sb.append(temp.data);
            if( temp.next != null )
            {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

}