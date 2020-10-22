class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if( grid.length == 0 || grid[0].length == 0 ) return -1;

        int n = grid.length;
        int m = grid[0].length;

        if( grid[0][0] == 1 || grid[n-1][m-1] == 1 ) return -1;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};

        Queue<Integer> qu = new LinkedList<>();
        qu.add( 0 * m + 0 );
        grid[0][0] = 1;

        int level = 1;
        while( qu.size() != 0 )
        {
            int size = qu.size();
            while( size-- > 0 )
            {
                int vtx = qu.remove();

                int r = vtx / m;
                int c = vtx % m;

                if( r == n - 1 && c == m - 1 ) return level;

                for( int d = 0; d < dir.length; d++ )
                {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if( x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0 )
                    {
                        qu.add( x * m + y );
                        grid[x][y] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}