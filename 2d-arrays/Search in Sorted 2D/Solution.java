import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[ n ][ m ];

        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < m; j++ )
            {
                mat[i][j] = scn.nextInt();
            }
        }

        int k = scn.nextInt();

        int i = 0, j = mat[ 0 ].length - 1;

        // 1 2 3
        // 4 5 6
        // 7 12 13

        // 12

        while( i <= mat.length - 1 && i >= 0 && j >= 0 && j <= mat[0].length - 1 )
        {
            if( mat[i][j] == k )
            {
                System.out.println( i );
                System.out.println( j );
                return;
            }
            else if( mat[i][j] > k  )
            {
                j--;
            }
            else
            {
                i++;
            }
        } 
    }
}