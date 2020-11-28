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

        public int compareTo( int a, int b ){
            if( this.isMax ){
                return this.arr.get( a ) - this.arr.get( b );
            }else{
                return this.arr.get( b ) - this.arr.get( a );
            }
        }

        public void constructHeap( int[] data ){
            for( int ele : data ) this.arr.add( ele );
            int n = this.arr.size();

            for( int i = n - 1; i >= 0; i-- ){
                downHeapify( i );
            }
        }

        public void swap( int a, int b ){
            int val1 = this.arr.get( a );
            int val2 = this.arr.get( b );

            this.arr.set( a, val2 );
            this.arr.set( b, val1 );
        }

        public void downHeapify( int pi ){
            int maxIdx = pi;
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;

            if( lci < this.arr.size() && compareTo( lci, maxIdx ) > 0 )
                maxIdx = lci;
            if( rci < this.arr.size() && compareTo( rci, maxIdx ) > 0 )
                maxIdx = rci;
            
            if( pi != maxIdx ){
                swap( pi, maxIdx );
                downHeapify( maxIdx );
            }
        }

        public void upHeapify( int ci ){
            int pi = ( ci - 1 )/2;

            if( pi >= 0 && compareTo( ci, pi ) > 0 ){
                swap( pi, ci );
                upHeapify( pi );
            }
        }

        public void push( int val ){
            this.arr.add( val );
            int n = this.arr.size();
            upHeapify( n - 1 );
        }

        public int top(){
            return this.arr.get( 0 );
        }

        public int size(){
            return this.arr.size();
        }

        public boolean isEmpty(){
            return this.arr.size() == 0; 
        }

        public int remove(){
            int n = this.arr.size();

            swap( 0, n - 1 );
            int rv = this.arr.remove( n - 1 );
            downHeapify( 0 );
            return rv;
        }


    }

    public static void solve(){
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        Heap pq = new Heap( arr, false );
        
        pq.push( 50 );
        pq.push( 889 );
        System.out.println();
        System.out.println( pq.top() );
        while( pq.size() != 0 ){
            System.out.println( pq.remove() );
        }

    }
    public static void main(String[] args) {
        solve();
    }
}