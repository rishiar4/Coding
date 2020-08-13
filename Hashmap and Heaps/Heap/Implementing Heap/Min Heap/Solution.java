import java.util.ArrayList;

public class Solution{

    public static class Heap{

        ArrayList<Integer> arr = new ArrayList<>();

        public Heap( int[] data )
        {
            for( int val : data )
            {
                arr.add( val );
            }

            for( int i = this.arr.size() - 1; i >= 0; i--  )
            {
                downHeapify( i );
            }
        }

        public int pop()
        {
            if( this.arr.size() == 0 )
            {
                System.out.println("Underflow");
                return -1;
            }
            else
            {
                swap( 0, this.arr.size() - 1 );
                int rV = this.arr.remove( this.arr.size() - 1 );
                downHeapify( 0 );
                return rV;
            }
        }

        public void downHeapify( int pi )
        {
            int minIdx = pi;
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;

            if( lci < this.arr.size() && this.arr.get( minIdx ) > this.arr.get( lci ) )
            {
                minIdx = lci;
            }
            if( rci < this.arr.size() && this.arr.get( minIdx ) > this.arr.get( rci ) )
            {
                minIdx = rci;
            }

            if( pi != minIdx )
            {
                swap(pi, minIdx);
                downHeapify( minIdx );
            }
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

        public void upHeapify( int ci )
        {
            int pi = ( ci - 1 )/2;

            if( pi >= 0  && this.arr.get( ci ) < this.arr.get( pi ) )
            {
                swap( ci, pi );
                upHeapify( pi );
            }
        }

        public void push( int x )
        {
            this.arr.add( x );
            upHeapify( this.arr.size() - 1 );
        }
    }
    public static void main(String[] args) {
        
        int[] arr = { 1, 85,69, 25, 36, -63, -36, 45};

        Heap hp = new Heap( arr );

        hp.push( 140 );
        hp.push( 15 );

        while( hp.size() != 0 )
        {
            System.out.println( hp.pop() );
        }
    }
}