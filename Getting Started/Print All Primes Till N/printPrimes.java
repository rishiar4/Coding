import java.util.*;

public class printPrimes{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );

        int n = scn.nextInt();

        for(int i = 2; i < n; i++ )
        {
            boolean ans = checkPrime( i );
            if( ans )
            {
                System.out.print( i + " ");
            }
        }
    }

    public static boolean checkPrime( int n )
    {
        for( int i = 2; i < Math.sqrt( n ) + 1; i++ )
        {
            if( n % i == 0 )
            {
                return false;
            }
        }
        return true;
    }
}