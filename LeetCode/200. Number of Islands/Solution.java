class Solution {

    public void numIslandsDFS( char[][] grid, int r, int c, int[][] dir ){

        grid[r][c] = '0';
        for( int d = 0; d < dir.length; d++ )
        {
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            if( x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1' )
            {
                numIslandsDFS( grid, x, y, dir );
            }
        }
    }

    public int numIslands(char[][] grid) {
        int[][] dir = { {0,1}, {0,-1}, {1,0}, {-1,0} };
        int count = 0;
        for( int i = 0; i < grid.length; i++ )
        {
            for( int j = 0; j < grid[0].length; j++ )
            {
                if( grid[i][j] == '1' )
                {
                    numIslandsDFS( grid, i, j, dir);
                    count++;
                }
            }
        }
        return count;
    }
}