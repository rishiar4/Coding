public class DQueue extends Queue{
    DQueue()
    {
        super(10);
    }
    DQueue(int n)
    {
        super(n);
    }
    
    @Override
    public void add( int val )
    {
        if( super.size() == super.capacity() )
        {
            int[] temp = new int[super.size()];
            int i = 0;
            while(  super.size() != 0 )
            {
                temp[i++] = super.remove();
            }

            super.assignSize( temp.length * 2 );

            for( int ele : temp )
            {
                super.add( ele );
            }
        }
        super.add( val );
    }
}