import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();

        int nstars = 1;
        int nspaces = n/2;

        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < nspaces; j++  )
            {
                if( i == n/2 )
                {
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            for( int j = 0; j < nstars; j++ )
            {
                System.out.print("*\t");
            }

            if( i >= n/2 )
            {
                nstars--;
            }
            else
            {nstars++;}
            System.out.println();
        }
    }
}