class Solution {
    public int minCostClimbingStairs( int n, int[] cost){
        if( n <= 1 )
            return cost[n];
        
        int val = Math.min( minCostClimbingStairs( n - 1, cost), minCostClimbingStairs( n - 2, cost) );

        return val + ( n < cost.length ? cost[n] : 0 );
    }

    public int minCostClimbingStairs( int n, int[] cost, int[] dp){
        if( n <= 1)
            return dp[n] = cost[n];

        if( dp[n] != 0)
            return dp[n];

        int val = Math.min( minCostClimbingStairs( n - 1, cost, dp), minCostClimbingStairs( n - 2, cost, dp) );

        return dp[n] = val + ( n < cost.length ? cost[n] : 0);
    }

    public int minCostClimbingStairsDP( int N, int[] cost, int[] dp){
        for( int n = 0; n <= N; n++ ){
        if( n <= 1){
            dp[n] = cost[n];
            continue;
        }
        int val = Math.min( dp[n-1], dp[n-2] );

        dp[n] = val + ( n < cost.length ? cost[n] : 0); 
        }
        return dp[N];
    }

    public int minCostClimbingStairs(int[] cost) {
        if( cost.length == 0 )
            return 0;

        int n = cost.length;
        // int ans = minCostClimbingStairs( n, cost );
        int[] dp = new int[ n + 1 ];
        // int ans = minCostClimbingStairs( n, cost, dp);
        int ans = minCostClimbingStairsDP( n, cost, dp);
        return ans;
    }
}