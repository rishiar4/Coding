class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dir = { {-1,0}, {0,1}, {1,0}, {0,-1} };

        int countOnes = 0, countNbrs = 0;
        for( int i = 0; i < grid.length; i++ )
        {
            for( int j = 0; j < grid[0].length; j++ )
            {
                if( grid[i][j] == 1 )
                {
                    countOnes++;

                    for( int d = 0; d < dir.length; d++ )
                    {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];

                        if( r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1 )
                        {
                            countNbrs++;
                        }
                    }
                }
            }
        }
        return 4 * countOnes - countNbrs;
    }
}