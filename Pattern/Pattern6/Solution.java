import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );

        int n = scn.nextInt();
        int nstars = n/2 + 1;
        int nspaces = 1;

        for( int i = 0; i < n; i++  )
        {
            for( int j = 0; j < nstars; j++ )
            {
                System.out.print("*\t");
            }
            for( int j = 0; j < nspaces; j++ )
            {
                System.out.print("\t");
            }
            for( int j = 0; j < nstars; j++ )
            {
                System.out.print("*\t");
            }
            if( i > n/2 - 1 )
            {
                nspaces-=2;
                nstars++;
            }
            else
            {
                nstars--;
                nspaces+=2;
            }
            System.out.println();
        }
    }
}