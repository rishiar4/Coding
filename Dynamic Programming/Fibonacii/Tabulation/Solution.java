public  class Solution{
    
    public static int fib( int N, int[] dp)
    {
        for( int n = 0; n <= N; n++ )
        {
        if( n <= 1 ) {
            dp[n] = n;
            continue;
        }

        int a = dp[ n - 1 ]; //  fib( n - 1, dp );
        int b = dp[ n - 2 ]; // fib( n - 2, dp );

        dp[n] = a + b;
     }
     return dp[N];
    }
    
    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n+1];
        System.out.println( fib( n, dp ) );
    }
}