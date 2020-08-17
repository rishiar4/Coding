import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int nstars = 1;
        int f = 0, s = 1;
        int t = f + s;
        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < nstars; j++ )
            {
                System.out.print(f+" ");
                f = s;
                s = t;
                t = f + s;
            }
            System.out.println();
            nstars++;
        }
    }
}