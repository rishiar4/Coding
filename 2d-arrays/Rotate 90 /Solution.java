import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for( int i = 0; i < n; i++ )
        {
            for(int j = 0 ; j < m; j++ )
            {
                mat[i][j] = scn.nextInt();
            }
        }

        // Reverse Each row

        for( int i = 0; i < n; i++ )
        {
            int k = mat[i].length - 1;
            for( int j = 0; j < mat[i].length/2; j++ )
            {
                int val = mat[i][j];
                mat[i][j] = mat[i][k-j];
                mat[i][k-j] = val;
            }
        }

        //Transpose

        for( int i = 0; i < mat.length; i++ )
        {
            for( int j  = i + 1; j < mat[0].length; j++ )
            {
                swap( mat, i, j );
            }
        }

        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < m; j++ )
            {
                System.out.print( mat[i][j] + " " );
            }
            System.out.println();
        }
    }

    public static void swap( int[][] mat , int a , int b )
    {
        int val1 = mat[a][b];
        int val2 = mat[b][a];

        mat[a][b] = val2;
        mat[b][a] = val1;

    }
}