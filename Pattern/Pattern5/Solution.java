import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nspaces = n/2;
        int nstars = 1;

        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < nspaces; j++ )
            {
                System.out.print("\t");
            }
            for( int j = 0; j < nstars; j++ )
            {
                System.out.print("*\t");
            }
            if( i < n/2 )
            {
                nspaces--;
                nstars+=2;
            }
            else
            {
                nspaces++;
                nstars-=2;
            }
            System.out.println();
        }

    }
}