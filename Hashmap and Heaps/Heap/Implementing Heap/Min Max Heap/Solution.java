import java.util.ArrayList;
public class Solution{

    public static class MIN_MAX_HEAP{
        ArrayList<Integer> arr = new ArrayList<>();
        boolean isMax = false;

        public MIN_MAX_HEAP( int[] data, boolean isMax )
        {
            this.isMax = isMax;
            buildHeap( data );
        }

        public void buildHeap( int[] data )
        {
            for(int ele : data )
            {
                arr.add( ele );
            }

            for( int i = this.arr.size() - 1; i >= 0; i-- )
            {
                downHeapify( i );
            }
        }

        public int compareTo( int a, int b )
        {
            if( isMax )
            {
                return this.arr.get( a ) - this.arr.get( b );
            }
            else
            {
                return this.arr.get( b ) - this.arr.get( a );
            }
        }

        //Downheapify

        public void downHeapify( int pi )
        {
            int maxIdx = pi;
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;

            if( lci < this.arr.size() && compareTo( lci, maxIdx ) > 0 )
            {
                maxIdx = lci;
            }

            if( rci < this.arr.size() && compareTo( rci, maxIdx ) > 0 )
            {
                maxIdx = rci;
            }

            if( pi != maxIdx )
            {
                swap( pi, maxIdx );
                downHeapify( maxIdx );
            }
        }

        //Upheapify
        public void upHeapify( int ci )
        {
            int pi = ( ci - 1 )/2;

            if( pi >= 0 && compareTo( pi,ci ) > 0 )
            {
                swap( pi, ci );
                upHeapify( pi );
            }
        }

        public void push( int x )
        {
            this.arr.add( x );
            upHeapify( this.arr.size() - 1 );
        }

        public int pop()
        {
            swap( 0, this.arr.size() - 1 );
            int rv = this.arr.remove( this.arr.size() - 1 );
            downHeapify( 0 );
            return rv;
        }
        public void swap( int a, int b )
        {
            int val1 = this.arr.get( a );
            int val2 = this.arr.get( b );

            this.arr.set( a, val2 );
            this.arr.set( b, val1 );
        }

        public int size()
        {
            return this.arr.size();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 14,85,96,69,36,45,-2,96};

        MIN_MAX_HEAP pq = new MIN_MAX_HEAP( arr, true );

        while( pq.size() != 0 )
        {
            System.out.println( pq.pop() );
        }

        System.out.println("-------------------------");

        MIN_MAX_HEAP PP = new MIN_MAX_HEAP( arr, false );

        while( PP.size() != 0 )
        {
            System.out.println( PP.pop() );
        }

    }
}