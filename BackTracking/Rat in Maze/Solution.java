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
    public static int ratInMaze(  int sr, int sc, int[][] trap, int[][] ans, int jump )
    {
        if( sr == ans.length - 1 && sc == ans[0].length - 1 )
        {
            ans[sr][sc] = jump;
            display( ans );
            ans[sr][sc] = 0;
            System.out.println();
            return 1;
        }
        int count = 0;
        ans[ sr ][ sc ] = jump++; 

        if( sr + 1 < trap.length && trap[ sr + 1 ][ sc ] == 0  )
        {
            // ans[ sr + 1 ][ sc ] = 1;
            count += ratInMaze( sr + 1 , sc, trap, ans, jump );
            // ans[ sr + 1 ][ sc ] = 0; 
        }

        if( sc + 1 < trap[0].length && trap[ sr ][ sc + 1] == 0 )
        {
            // ans[ sr ][ sc + 1 ] = 1;
            count += ratInMaze( sr, sc + 1, trap, ans, jump );
        }
        
        ans[ sr ][ sc ] = 0;  
        return count;
    }
    public static void solve()
    {
        int[][] trap = { 
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0} };
            
        System.out.println( ratInMaze( 0, 0, trap, new int[trap.length][trap[0].length], 4 ) );
    }
    public static void main(String[] args) {
        solve();
    }
}