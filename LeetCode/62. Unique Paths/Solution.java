class Solution {
    public int uniquePaths( int sr, int sc, int dr, int dc, int[][] dir )
    {
        if( sr == dr - 1 && sc == dc - 1 )
        {
            return 1;
        }

        int count = 0;

        for( int d = 0; d < dir.length; d++ )
        {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && y >= 0 && x < dr && y < dc )
            {
                count += uniquePaths( x, y, dr, dc, dir );
            }
        }

        return count;
    }

    public int uniquePaths_Mem( int sr, int sc, int dr, int dc, int[][] dir, int[][] dp )
    {
        if( sr == dr - 1 && sc == dc - 1 )
        {
            return dp[sr][sc] = 1;
        }

        if( dp[sr][sc] != 0 ) return dp[sr][sc];

        int count = 0;
        for( int d = 0; d < dir.length; d++ )
        {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && y >= 0 && x < dr && y < dc )
            {
                count += uniquePaths_Mem( x, y, dr, dc, dir, dp );
            }
        }

        return dp[sr][sc] = count;
    }

    public int uniquePathsDP( int SR, int SC, int dr, int dc, int[][] dir, int[][] dp )
    {
        for( int sr = dr - 1; sr >= 0; sr-- )
        {
            for( int sc = dc - 1; sc >= 0; sc-- )
            {
                if( sr == dr - 1 && sc == dc - 1 )
                {
                    dp[sr][sc] = 1;
                    continue;
                }

        int count = 0;
        for( int d = 0; d < dir.length; d++ )
        {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && y >= 0 && x < dr && y < dc )
            {
                count += dp[x][y]; // uniquePaths_Mem( x, y, dr, dc, dir, dp );
            }
        }

            dp[sr][sc] = count;
        }
        }

        return dp[SR][SC];
    }

    public int uniquePaths(int m, int n) {

        int[][] dir = { { 0, 1}, { 1, 0} };
        // return uniquePaths( 0, 0, m, n, dir );
        int[][] dp = new int[m][n];

        // return uniquePaths_Mem( 0, 0, m, n, dir, dp );

        return uniquePathsDP( 0, 0, m, n, dir, dp );

    }
}
