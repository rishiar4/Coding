class Solution {

    public void surrondedDFS( char[][] board, int x, int y, int[][] dir )
    {
        board[x][y] = '@';
        for( int d = 0; d < dir.length; d++ )
        {
            int r = x + dir[d][0];
            int c = y + dir[d][1];

            if( r >= 0 && c >= 0 && r < board.length && c < board[0].length  && board[r][c] == 'O' )
              surrondedDFS( board, r, c, dir)  ;
        }
    }

    public void solve(char[][] board) {

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for( int i = 0; i < board.length; i++ )
        {
            for( int j = 0; j < board[0].length; j++ )
            {
                if( i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1 )
                {
                    if( board[i][j] == 'O') 
                      surrondedDFS( board, i, j, dir );
                }
            }
        }

        for( int i = 0; i < board.length; i++ )
        {
            for( int j = 0; j < board[0].length; j++ )
            {
                if( board[i][j] == 'O' ) board[i][j] = 'X';
                else if( board[i][j] == '@' ) board[i][j] = 'O';
            }
        }

    }
}