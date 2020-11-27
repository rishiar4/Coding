import java.util.ArrayList;

public class l001{

    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        boolean isMax = true;

        public Heap( int[] data ){
            constructHeap( data );
        }

        public Heap( int[] data, boolean isMax ){
            this.isMax = isMax;
            constructHeap( data );
        }

        public  void constructHeap( int[] data ){
            for( int ele : data ) arr.add( ele );
            int n = this.arr.size();

            for( int i = n - 1; i >= 0; i-- ){
                downHeapify( i );
            }

            for( int ele : arr ) System.out.print( ele + " ");
        }

        public  void downHeapify( int pi ){
            int maxIdx = pi;
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;

            if( lci < this.arr.size() && this.arr.get( lci ) > this.arr.get( maxIdx ) )
                maxIdx = lci;
            if( rci < this.arr.size() && this.arr.get( rci ) > this.arr.get( maxIdx ) )
                maxIdx = rci;
            
            if( pi != maxIdx ){
                swap( pi, maxIdx );
                downHeapify( maxIdx );
            }
        }

        public void swap( int a, int b ){
            int val1 = this.arr.get( a );
            int val2 = this.arr.get( b );

            this.arr.set( a, val2 );
            this.arr.set( b, val1 );
        }

    }

    public static void main( String[] args ){
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        
        Heap pq = new Heap( arr );
    }
}