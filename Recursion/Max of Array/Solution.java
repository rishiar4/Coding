import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < arr.length; i++ )
        {
            arr[i] = scn.nextInt();
        }

        int max = maxOfArray( arr , 0 );

        System.out.println( max );
    }

    public static int maxOfArray( int[] arr, int index )
    {
        if( arr.length == index )
        {
            return arr[arr.length-1];
        }

        int max = arr[ index ];
        int nextMax = maxOfArray( arr, index + 1 );
        if( max < nextMax  )
        {
            max = nextMax;
        }
        return max;
    }
}