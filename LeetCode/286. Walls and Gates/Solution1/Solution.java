public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if( rooms.length == 0 || rooms[0].length == 0 ) return;

        int n = rooms.length;
        int m = rooms[0].length;

        LinkedList<Integer> qu = new LinkedList<>();
        int[][] dir = { {0,1}, {1,0}, {0,-1}, {-1,0} };

        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < m; j++ )
            {
                if( rooms[i][j] == 0 )
                   qu.addLast( i * m + j );
            }
        }
        
        int level = 0;
        while( qu.size() != 0 )
        {
            int size = qu.size();
            while( size-- > 0 )
            {
                int vtx = qu.removeFirst();

                int r = vtx / m;
                int c = vtx % m;

                for( int d = 0; d < dir.length; d++ )
                {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if( x >= 0 && y >= 0 && x < n && y < m && rooms[x][y] == 2147483647 )
                    {
                        rooms[x][y] = level + 1;
                        qu.addLast( x * m + y );
                    }
                }
            }
            level++;
        }

    }
}