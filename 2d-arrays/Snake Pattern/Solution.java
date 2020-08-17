import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];
        for( int i = 0; i < mat.length; i++ )
        {
            for( int j = 0; j < mat[0].length; j++ )
            {
                mat[i][j] = scn.nextInt();
            }
        }

        displaySnake( mat );
    }

    public static void displaySnake( int[][] mat )
    {
        for( int i = 0; i < mat.length; i++ )
        {
            if( i % 2 == 0 )
            {
                int n = mat[i].length;
                int k  = 0;
                while( k < n )
                {
                    System.out.print( mat[i][k++] + " ");
                }
            }
            else
            {
                int n = mat[i].length - 1;
                while( n >= 0 )
                {
                    System.out.print( mat[i][n--] +" ");
                }

            }
        }
    }
}