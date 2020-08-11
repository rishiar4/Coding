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
        int k = scn.nextInt();

        int pos = bSearch( arr, k );
        System.out.println( pos );
    }
    
    public static int bSearch( int[] arr, int k )
    {
        int low = 0, high = arr.length - 1;
        int mid = low + ( high - low )/2;
        
        while( low < high )
        {
            if( arr[ mid ] == k )
            {
                return mid;
            }
            else if( arr[ mid ] > k )
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
}