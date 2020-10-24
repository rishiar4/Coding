public  class Solution{
    
    public static int fib( int n, int[] dp)
    {
        if( n <= 1 ) return dp[n] = n;

        if( dp[n] != 0 ) return dp[n];

        int a = fib( n - 1, dp );
        int b = fib( n - 2, dp );

        return dp[n] = a + b; 
    }
    
    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n+1];
        System.out.println( fib( n, dp ) );
    }
}