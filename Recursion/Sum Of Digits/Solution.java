import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        System.out.println( sumofD( n ) );
    }

    public static int sumofD( int n )
    {
        if( n == 0 )
        {
            return 0;
        }
        int d = n % 10;
        int ans = sumofD( n / 10 ) + d;
        return ans;
    }
}