import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int k = 1;
        int nstars = 1;
        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < nstars; j++ )
            {
                System.out.print(k+"\t");
                k++;
            }
            nstars++;
            System.out.println();
        }
    }
}