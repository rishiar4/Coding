import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        
        int[][] mat = new int[n1][m1];
        for( int i = 0; i < n1; i++ )
        {
            for( int j = 0; j < m1; j++ )
            {
                mat[i][j] = scn.nextInt();
            }
        }

        
        for( int i = 0; i < m1; i++ )
        {
            if( i % 2 == 0 )
            { 
                for( int j = 0; j < n1 ; j++ )
                {
                    System.out.println( mat[j][i]  );
                }
            }

            else
            {
                for( int j = n1 - 1; j >= 0; j-- )
                {
                    System.out.println( mat[j][i] );
                }
            }
        }
    }
}
