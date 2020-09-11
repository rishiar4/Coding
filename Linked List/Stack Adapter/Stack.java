import java.util.LinkedList;
public class Stack{
    
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

    protected void decreaseSize()
    {
        this.size--;
    }

    
    protected void nodePush( Node node )
    {
        if( this.head == null )
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

    public void push( int val )
    {
        Node node = new Node( val );
        nodePush( node );
    }

    protected Node nodePop()
    {
        Node node = this.head;
        this.head = this.head.next;
        node.next = null;
        decreaseSize();
        return node;
    }

    public int pop() throws Exception
    {
        if( this.size == 0 )
        {
            throw new Exception("Null Pointer Exception");
        }

        Node node = nodePop();
        return node.data;
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node temp = this.head;
        while( temp != null )
        {
            sb.append( temp.data );
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