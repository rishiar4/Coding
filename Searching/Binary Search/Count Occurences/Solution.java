import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++ )
        {
            arr[ i ] = scn.nextInt();
        }
        int k = scn.nextInt();

        int lPosition = lBSearch( arr, k );
        System.out.println( lPosition );
        int rPosition = rBSearch( arr, k );
        System.out.println( rPosition );

        System.out.println( rPosition - lPosition + 1 );
    }

    public static int lBSearch( int[] arr, int k )
    {
        int low = 0, high = arr.length - 1;
        int mid = low + ( high - low )/2;
        
        while( low <= high )
        {
            if( arr[ mid ] == k && ( mid == 0 || arr[ mid - 1 ] != k ) )
            {
                return mid;
            }
            else if( arr[ mid ] >= k  )
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
            mid = low + ( high - low )/2;
        }
        return -1;
    }

    public static int rBSearch( int[] arr, int k )
    {
        int low = 0, high = arr.length - 1;
        int mid = low + ( high - low )/2;

        while( low <= high )
        {
            if( arr[ mid ] == k && ( mid == arr.length-1 || arr[ mid + 1 ] != k ) )
            {
                return mid;
            }
            else if( arr[ mid ] <= k )
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
            mid = low + ( high - low )/2;
        }
        return -1;
    }
}