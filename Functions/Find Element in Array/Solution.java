import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr  = new int[n];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int pos = find( arr, k );
        
        System.out.println( pos );
    }

    public static int find( int[] arr, int k )
    {
        for( int i = 0; i < arr.length; i++ )
        {
            if( arr[i] == k )
            {
                return i;
            }
        }
        return -1;
    }
}