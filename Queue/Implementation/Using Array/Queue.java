public class Queue{
    private int[] qu;
    private int f;
    private int b;
    private int elements;
    private int totalSize;

    Queue()
    {
        assignSize(10);
    }

    Queue(int n)
    {
        assignSize(n);
    }

    protected void assignSize(int n)
    {
        this.qu = new int[n];
        this.f = 0;
        this.b = 0;
        this.elements = 0;
        this.totalSize = n;
    }

    public boolean isEmpty()
    {
        return this.elements == 0; 
    }

    public int size()
    {
        return this.elements;
    }

    protected int capacity()
    {
        return this.totalSize;
    }

    public void add( int val )
    {
        if(this.elements == this.totalSize)
        {
            System.out.println("Queue Underflow");
            return;
        }
        else{
            this.qu[this.b] = val;
            this.b = ( this.b + 1 ) % this.totalSize;
            this.elements++;
        }
    }
    public int front()
    {
        if (this.elements == 0)
            {
                System.out.println("Queue Underflow");
                return -1;
            }

        return this.qu[this.f];
    }
    public int remove()
    {
        if(this.elements == 0)
        {
            System.out.println("Queue Underflow");
            return -1;
        }
        else
        {
            int rv = this.qu[this.f];
            this.qu[this.f] = 0;
            this.f = (this.f + 1) % this.totalSize;
            this.elements--;
            return rv;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for( int i = 0; i < this.elements; i++ )
        {
            int idx = (this.f + i)%this.totalSize;
            sb.append(this.qu[idx]);
            if( i != this.elements - 1 )
            {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}