public class questions{
    // LeetCode 62
    static int[][] dir = { { 1, 0}, { 0, 1} };

    public int uniquePaths( int sr, int sc, int er, int ec){
        if( sr == er - 1 && sc == ec - 1){
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec){
                count += uniquePaths( x, y, er, ec);
            }
        }
        return count;
    }

    public int uniquePathsM( int sr, int sc, int er, int ec, int[][] dp){
        if( sr == er - 1 && sc == ec - 1){
            return dp[sr][sc] = 1;
        }

        if( dp[sr][sc] != 0 )
            return dp[sr][sc];
        
        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec){
                count += uniquePathsM( x, y, er, ec, dp);
            }
        }
        return dp[sr][sc] = count;
    }

    public int uniquePathsDP( int SR, int SC, int er, int ec, int[][] dp){
        for( int sr = er - 1; sr >= 0; sr-- ){
            for( int sc = ec - 1; sc >= 0; sc-- ){
                if( sr == er - 1 && sc == ec - 1){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for( int d = 0; d < dir.length; d++){
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
        
                    if( x >= 0 && x < er && y >= 0 && y < ec){
                        count += dp[x][y]; // uniquePathsM( x, y, er, ec, dp);
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }

    public int uniquePaths(int m, int n) {
        // return uniquePaths( 0, 0, m, n);
        int[][] dp = new int[m][n];
        // return uniquePathsM( 0, 0, m, n, dp);
        return uniquePathsDP( 0, 0, m, n, dp);
    }
    // LeetCode 63
    static int[][] dir = { { 1, 0}, { 0, 1} };

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int sr, int sc, int er, int ec){
        if( sr == er - 1 && sc == ec - 1){
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec && obstacleGrid[x][y] == 0 ){
                count += uniquePathsWithObstacles(obstacleGrid, x, y, er, ec);
            }
        }
        return count;
    }

    public int uniquePathsWithObstaclesMem( int[][] obstacleGrid, int sr, int sc, int er, int ec, int[][] dp){
        if( sr == er - 1 && sc == ec - 1){
            return dp[sr][sc] = 1;
        }

        if( dp[sr][sc] != 0 )
            return dp[sr][sc];

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec && obstacleGrid[x][y] == 0){
                count += uniquePathsWithObstaclesMem( obstacleGrid, x, y, er, ec, dp);
            }
        }
        
        return dp[sr][sc] = count;
    }

    public int uniquePathsWithObstaclesDP( int[][] obstacleGrid, int SR, int SC, int er, int ec, int[][] dp ){
        for( int sr = er - 1; sr >= 0; sr-- ){
            for( int sc = ec - 1; sc >= 0; sc-- ){
                if( sr == er - 1 && sc == ec - 1){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for( int d = 0; d < dir.length; d++ ){
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
        
                    if( x >= 0 && x < er && y >= 0 && y < ec && obstacleGrid[x][y] == 0){
                        count += dp[x][y]; //uniquePathsWithObstaclesMem( obstacleGrid, x, y, er, ec, dp);
                    }
                }
                
                dp[sr][sc] = count;   
            }
        }

        return dp[SR][SC];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if( obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if( obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1 )
            return 0;

        // return uniquePathsWithObstacles( obstacleGrid, 0, 0, n, m);
        int[][] dp = new int[n][m];
        // int ans = uniquePathsWithObstaclesMem( obstacleGrid, 0, 0, n, m, dp );

        // for( int[] a : dp ){
        //     for( int ele : a ){
        //         System.out.print( ele + " " );
        //     }
        //     System.out.println();
        // }
        int ans = uniquePathsWithObstaclesDP( obstacleGrid, 0, 0, n, m, dp );
        return ans;
    }

    // LeetCode 64
    static int[][] dir = { { 1, 0 }, { 0, 1} };

    public int minPathSum( int[][] grid, int sr, int sc, int er, int ec ){
        if( sr == er - 1 && sc == ec - 1){
            return grid[sr][sc];
        }

        int minCost = (int)1e8;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            
            if( x >= 0 && x < er && y >= 0 && y < ec )
                minCost = Math.min( minCost, minPathSum( grid, x, y, er, ec ) );
        }

        return minCost + grid[sr][sc];
    }

    public int minPathSum( int[][] grid, int sr, int sc, int er, int ec, int[][] dp ){
        if( sr == er - 1 && sc == ec - 1){
            return dp[sr][sc] = grid[sr][sc];
        }
        
        if( dp[sr][sc] != (int)1e8)
            return dp[sr][sc];

        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            
            if( x >= 0 && x < er && y >= 0 && y < ec )
                dp[sr][sc] = Math.min( dp[sr][sc], minPathSum( grid, x, y, er, ec, dp ) );
        }

        return dp[sr][sc] += grid[sr][sc];
    }

    public int minPathSumDP( int[][] grid, int SR, int SC, int er, int ec, int[][] dp){
        for( int sr = er - 1; sr >= 0; sr--){
            for( int sc = ec - 1; sc >= 0; sc--){
                if( sr == er - 1 && sc == ec - 1){
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }
        
                for( int d = 0; d < dir.length; d++ ){
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
                    
                    if( x >= 0 && x < er && y >= 0 && y < ec )
                        dp[sr][sc] = Math.min( dp[sr][sc], dp[x][y] ); //minPathSum( grid, x, y, er, ec, dp ) );
                }
        
                dp[sr][sc] += grid[sr][sc];
            }
        }

        return dp[SR][SC];
    }

    public int minPathSum(int[][] grid) {
        if( grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int n = grid.length;
        int m = grid[0].length;

        // return minPathSum( grid, 0, 0, n - 1, m - 1);
        int[][] dp = new int[n][m];
        for( int[] a : dp ){
            Arrays.fill( a, (int)1e8 );
        }

        // int ans = minPathSum( grid, 0, 0, n , m , dp);
        int ans = minPathSumDP( grid, 0, 0, n, m, dp);
        for( int[] a : dp ){
            for( int ele : a ){
                System.out.print( ele + " ");
            }
            System.out.println();
        }
        return ans;
    }
}