import java.util.*; 

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];

        for( int i = 0; i < mat.length; i++ )
        {
            for( int j = 0; j < mat[i].length; j++ )
            {
                mat[i][j] = scn.nextInt();
            }
        }

        // 1 2 3 4
        // 7 5 6 8
        // 8 3 9 9
        // 1 6 3 9

        int rmin = 0, rmax = mat.length;
        int cmin = 0, cmax = mat[0].length;

        for( int i = 0; i < mat.length; i++ )
        {
            for( int j = 0; j < mat[0].length; j++ )
            {
                if (i == 0) 
                    System.out.print(mat[i][j] + " "); 
                else if (i == m - 1) 
                    System.out.print(mat[i][j] + " "); 
                else if (j == 0) 
                    System.out.print(mat[i][j] + " "); 
                else if (j == n - 1) 
                    System.out.print(mat[i][j] + " "); 
                // else
                //     System.out.print("  ")
            }
        }

        
    }
}
