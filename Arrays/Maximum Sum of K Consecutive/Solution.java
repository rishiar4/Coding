import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++ )
        {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int ans = maxWindowOfK( arr, k );
        System.out.println( ans );
    }

    public static int maxWindowOfK( int[] arr, int k )
    {
        int max = -(int)1e8;
        int window = 0;
        for( int i = 0; i < k; i++ ) window += arr[i];
        if( max < window ) max = window;
        
        for( int i = k; i < arr.length; i++ )
        {
            window = window - arr[ i - k ] + arr[ i ]; 
            if( max < window ) max = window;
        }
        return max;
    }
}