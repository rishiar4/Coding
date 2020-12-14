public class l001{
    
    public static void print( int[] arr ){
        for( int ele : arr ) System.out.print( ele + " ");
        System.out.println();
    }

    public static void print2D( int[][] arr ){
        for( int[] a : arr ) print( a );
    }

    public static int fibR( int n ){
        if( n <= 1 ) return n;

        return fibR( n - 1 ) + fibR( n - 2 );
    }

    public static int fibM( int n, int[] dp ){
        if( n <= 1 ) return dp[ n ] = n;

        if( dp[n] != 0 ) return dp[n];

        int a = fibM( n - 1, dp );
        int b = fibM( n - 2, dp );

        return dp[n] = a + b;
    }

    public static void fib(){
        int n = 9;
        // System.out.println( fibR( n ) );
        int[] dp = new int[ n + 1 ];
        System.out.println( fibM( n, dp ) );
        print( dp );
    }

    public static void twoPointer(){
        fib();
    }
    public static void solve(){
        twoPointer();
    }
    public static void main(String[] args) {
        solve();
    }
}