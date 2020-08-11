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
        int pos = bSearch( arr, k, 0, arr.length-1 );
        System.out.println( pos );
    }
    
    public static int bSearch( int[] arr, int k , int low, int high )
    {
        if( low > high )
        {
            return -1;
        }
        int mid = low + ( high - low )/2;
        if( arr[ mid ] == k )
        {
            return mid;
        }
        else if( arr[ mid ] < k )
        {
            return bSearch( arr, k, mid + 1, high );
        }
        else
        {
            return bSearch( arr, k, low, mid - 1  );
        }
    }
}