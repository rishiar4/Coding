import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];

        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < m; j++ )
            {
                mat[i][j] = scn.nextInt();
            }
        }

        int rmin = 0, rmax = mat.length - 1;
        int cmin = 0, cmax = mat[0].length - 1;

        int count = n * m;

        while( count > 0 )
        {
            for(int i = rmin; i<= rmax && count>0; i++)
			{
				System.out.println(mat[i][cmin]);
				count--;
			}
			cmin++;
			for(int i = cmin; i<=cmax && count>0; i++)
			{
				System.out.println(mat[rmax][i]);
				count--;
			}
			rmax--;
			for(int i = rmax; i>=rmin && count>0; i--)
			{
				System.out.println(mat[i][cmax]);
				count--;
			}
			cmax--;
			for(int i = cmax; i>=cmin && count>0; i--)
			{
				System.out.println(mat[rmin][i]);
				count--;
			}
			rmin++;

        }

    }
}