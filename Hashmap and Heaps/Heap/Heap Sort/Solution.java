import java.util.ArrayList;

public class Solution{

    public static class Heap
    {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean isMax = false;

        public Heap( int[] data, boolean isMax )
        {
            this.isMax = isMax;
            for( int ele : data )
            {
                arr.add( ele );
            }

            for( int i = arr.size(); i >= 0; i-- )
            {
                downHeapify( i, arr.size() - 1 );
            }
            
            int i = arr.size() - 1;
            while( i >= 0 )
            {
                swap(0, i-- );
                downHeapify(0,i);

                for( int p :arr )
                {
                  System.out.print( p + "  ");
                }
                System.out.println();
            }

            for( int p :arr )
            {
                System.out.print( p + "  ");
            }
        }

        public boolean compareTo( int a, int b)
        {
            if (isMax)
                return arr.get(a) > arr.get(b);
            else
                return arr.get(b) > arr.get(a);
        }

        public void swap( int a , int b )
        {
            int val1 = arr.get( a );
            int val2 = arr.get( b );

            arr.set( a, val2 );
            arr.set( b, val1 );
        }

        public  void downHeapify( int pi, int n )
        {
            int maxIdx = pi;
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;

            if (lci <= n && compareTo(lci, maxIdx))
                maxIdx = lci;
            if (rci <= n && compareTo(rci, maxIdx))
                maxIdx = rci;

            if (maxIdx != pi)
            {
                swap( pi , maxIdx );
                downHeapify(maxIdx,n);
            }

        }

    }

    public static void solve(){
        int[] arr = { 45,96,45,35,-3,-6,85,40,3,92 };
        int n = arr.length;
        boolean isMax = true;

        Heap hp = new Heap( arr, isMax );
    }

    public static void main(String[] args) {
        solve();
    }
}