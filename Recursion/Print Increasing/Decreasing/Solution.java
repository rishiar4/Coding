import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();

        print( n );
    }

    public static void print( int n )
    {
        if( n == 0 )
        {
            System.out.print( n +" ");
            return ;
        }
        System.out.print( n + " ");
        print( n - 1 );
        System.out.print( n + " ");
    }
}