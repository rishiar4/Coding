import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[ n ];

        for( int i = 0; i < arr.length; i++ )
        {
            arr[i] = scn.nextInt();
        }

        int span = findSpan( arr );

        System.out.println( span );
    }

    public static int findSpan( int[] arr )
    {
        int span = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for( int i = 0; i < arr.length; i++ )
        {
            if( arr[i] > max )
            {
                max = arr[i];
            }
            if( arr[i] < min )
            {
                min = arr[i];
            }
        }
        span = max - min;
        return span;
    }
}