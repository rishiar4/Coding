public class questions{
    // 200. Number of Islands
    public void numIslandsDFS( char[][] grid, int r, int c, int[][] dir){
        grid[r][c] = '0';
        for( int d = 0; d < dir.length; d++){
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            if( x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                numIslandsDFS( grid, x, y, dir);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int[][] dir = { { 0, 1}, { 1, 0}, { 0, -1}, { -1, 0}};
        int count = 0;
        for( int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[0].length; j++){
                if( grid[i][j] == '1'){
                    count++;
                    numIslandsDFS( grid, i, j, dir);
                }
            }
        }
        return count;
    }

    // 695. Max Area of Island
    public int maxAreaOfIsland( int[][] grid, int r, int c, int[][] dir){
        grid[r][c] = 0;
        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            if( x >= 0  && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1){
                count += maxAreaOfIsland( grid, x, y, dir);
            }
        }
        return count + 1; 
    }
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { { 0, 1}, { 0, -1}, { 1, 0}, { -1, 0} };
        int maxArea = 0;
        for( int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[0].length; j++){
                if( grid[i][j] == 1){
                    maxArea = Math.max( maxArea, maxAreaOfIsland( grid, i, j, dir));
                }
            }
        }
        return maxArea;
    }
    // 1091. Shortest Path in Binary Matrix
    public int shortestPathBinaryMatrix(int[][] grid) {
        if( grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int n = grid.length, m = grid[0].length;

        if( grid[0][0] == 1 && grid[n-1][m-1] == 1){
            return -1;
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        Queue<Integer> qu = new LinkedList<>();
        qu.add( 0 * m + 0);
        grid[0][0] = 1;
        int level = 1;
        while( qu.size() != 0){
            int size = qu.size();
            while( size >= 0){
                int idx = qu.remove();

                int r = idx / m;
                int c = idx % m;

                if( r == n - 1 && c == m - 1){
                    return level;
                }

                for( int d = 0; d < dir.length; d++){
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if( x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0){
                        qu.add( x * m + y);
                        grid[x][y] = 1;
                    }
                }

                size--;
            }
            level++;
        }
        return -1;
    }
}