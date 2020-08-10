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
        int k = scn.nextInt();

        int lIndex = getLast( arr, 0, k );
        System.out.println( lIndex );
    }

    public static int getLast( int[] arr, int index, int k )
    {
        if( arr.length == index )
        {
            return -1;
        }

        int ans = getLast( arr, index + 1, k );

        if( arr[index] == k )
        {
            ans = k;
        }
        return ans;
        


    }
}