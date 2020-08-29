import java.util.Scanner;
// import java.util
public class Solution{
    public static void display( int[][] ans )
    {
        for( int i = 0; i < ans.length; i++ )
        {
            for( int j = 0; j < ans[0].length; j++ )
            {
                System.out.print( ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int ratInMaze(  int sr, int sc, int[][] trap, int[][] ans )
    {
        if( sr == ans.length - 1 && sc == ans[0].length - 1 )
        {
            ans[sr][sc] = 1;
            display( ans );
            ans[sr][sc] = 0;
            System.out.println();
            return 1;
        }
        int count = 0;
        ans[ sr ][ sc ] = 1; 

        if( sr + 1 < trap.length && trap[ sr + 1 ][ sc ] == 0  )
        {
            // ans[ sr + 1 ][ sc ] = 1;
            count += ratInMaze( sr + 1 , sc, trap, ans );
            // ans[ sr + 1 ][ sc ] = 0; 
        }

        if( sc + 1 < trap[0].length && trap[ sr ][ sc + 1] == 0 )
        {
            // ans[ sr ][ sc + 1 ] = 1;
            count += ratInMaze( sr, sc + 1, trap, ans );
            // ans[ sr ][ sc + 1 ] = 0;  
        }

        // trap[ sr ][ sc ] = 0;
        return count;
    }
    public static void solve()
    {
        int[][] trap = { 
            {0, 1, 1, 1},
            {0, 0, 1, 0},
            {1, 0, 1, 1},
            {0, 0, 0, 0} };
            
        System.out.println( ratInMaze( 0, 0, trap, new int[trap.length][trap[0].length] ) );
    }
    public static void main(String[] args) {
        solve();
    }
}