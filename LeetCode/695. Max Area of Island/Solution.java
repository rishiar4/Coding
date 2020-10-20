class Solution {

    public int maxAreaOfIslandDFS( int[][] grid, int x, int y, int[][] dir ){
        int count = 0;
        grid[x][y] = 0;
        
        for( int d = 0; d < dir.length; d++ )
        {
            int r = x + dir[d][0];
            int c = y + dir[d][1];

            if( r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1 )
            {
                count += maxAreaOfIslandDFS( grid, r, c, dir );
            }
        }

        return count + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { {-1,0}, {0,1}, {1,0}, {0,-1} };
        int maxArea = 0;

        for( int i = 0; i < grid.length; i++ )
        {
            for( int j = 0; j < grid[0].length; j++ )
            {
                if( grid[i][j] == 1 ) 
                 maxArea = Math.max( maxArea, maxAreaOfIslandDFS( grid, i, j, dir ) );
            }
        }

        return maxArea;
    }
}