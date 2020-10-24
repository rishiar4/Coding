class Solution {

    static int[][] dir = { { 0, 1 },{ 1,0} };
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid, int sr, int sc, int dr, int dc) {
        if (sr == dr - 1 && sc == dc - 1) {
            return 1;
        }

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if (x >= 0 && y >= 0 && x < dr && y < dc && obstacleGrid[x][y] == 0) {
                count += uniquePathsWithObstacles(obstacleGrid, x, y, dr, dc);
            }
        }
        return count;
    }

    public int uniquePathsWithObstaclesMem(int[][] obstacleGrid, int sr, int sc, int dr, int dc, int[][] dp) {
        if (sr == dr - 1 && sc == dc - 1) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0) return dp[sr][sc];

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if (x >= 0 && y >= 0 && x < dr && y < dc && obstacleGrid[x][y] == 0) {
                count += uniquePathsWithObstaclesMem(obstacleGrid, x, y, dr, dc, dp);
            }
        }
        return dp[sr][sc] = count;
    }

    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid, int SR, int SC, int dr, int dc, int[][] dp) {
        for (int sr = dr - 1; sr >= 0; sr--) {
            for (int sc = dc - 1; sc >= 0; sc--) {
                if (sr == dr - 1 && sc == dc - 1) {
                    dp[sr][sc] = 1;
                    continue;
                }
                int count = 0;

                for (int d = 0; d < dir.length; d++) {
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];

                    if (x >= 0 && y >= 0 && x < dr && y < dc && obstacleGrid[x][y] == 0) {
                        count += dp[x][y]; // uniquePathsWithObstaclesMem( obstacleGrid, x, y, dr, dc, dp );
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) return 0;

        int[][] dp = new int[n][m];
        // return uniquePathsWithObstacles( obstacleGrid, 0, 0, n, m );
        // return uniquePathsWithObstaclesMem( obstacleGrid, 0, 0, n, m, dp );

        return uniquePathsWithObstaclesDP(obstacleGrid, 0, 0, n, m, dp);
    }
}