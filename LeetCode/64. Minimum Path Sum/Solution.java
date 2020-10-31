class Solution {
    static int[][] dir = { { 1, 0}, { 0, 1} };
    public int minPathSumMem( int sr, int sc, int dr, int dc, int[][] dp, int[][] grid ){
        if( sr == dr  && sc == dc  ){
            return dp[sr][sc] = grid[sr][sc];
        }

        if( dp[sr][sc] != (int)1e8 ) return dp[sr][sc];

        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && y >= 0 && x < grid.length && y < grid[0].length ){
                dp[sr][sc] = Math.min( dp[sr][sc], minPathSumMem( x, y, dr, dc, dp, grid) );
            }
        }
        return dp[sr][sc]+= grid[sr][sc];
    }
    public int minPathSumDP( int SR, int SC, int dr, int dc, int[][] dp, int[][] grid ){
        for( int sr = dr; sr >= 0; sr-- ){       
            for( int sc = dc ; sc >= 0; sc-- ){
                if( sr == dr && sc == dc ){
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }
        
                for( int d = 0; d < dir.length; d++ ){
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
        
                    if( x >= 0 && y >= 0 && x < grid.length && y < grid[0].length ){
                        dp[sr][sc] = Math.min( dp[sr][sc],  dp[x][y] );//minPathSumMem( x, y, dr, dc, dp, grid) );
                    }
                }
                dp[sr][sc]+= grid[sr][sc];
            }
        }
        return dp[SR][SC];
    }
    public int minPathSum(int[][] grid) {
        if( grid.length == 0 || grid[0].length == 0 ) return 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for( int[] a : dp ){
            Arrays.fill(a, (int)1e8);
        }
        
        int ans = minPathSumDP( 0, 0, n - 1, m - 1, dp, grid);
        return ans;
    }
}