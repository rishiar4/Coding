class Solution {
     public int climbStairsR( int n){
        if( n <= 1 )
            return 1;

        int val = climbStairsR( n - 1 ) + climbStairsR( n - 2 );

        return val;
    }

    public int climbStairs( int n, int[] dp){
        if( n <= 1 )
            return dp[n] = 1;

        if( dp[n] != 0)
            return dp[n];

        int val = climbStairs( n - 1, dp) + climbStairs( n - 2,dp );

        return dp[n] = val;    
    }

    public int climbStairsDP( int N, int[] dp){
        for( int n = 0; n <= N; n++){
        if( n <= 1 ){
            dp[n] = 1;
            continue;
        }
        int val = climbStairs( n - 1, dp) + climbStairs( n - 2,dp );

        dp[n] = val;  
        }
        return dp[N];
    }

    public int climbStairs(int n) {
        // int ans = climbStairsR( n );
        int[] dp = new int[ n + 1 ];
        // int ans = climbStairs( n, dp);
        int ans = climbStairsDP( n, dp);
        return ans;
    }
}