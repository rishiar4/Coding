import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[ n ];
        for( int i = 0; i < n; i++ )
        {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int index = getFirst( arr, 0, k );
        System.out.println( index );
    }

    public static int getFirst( int[] arr, int index, int k )
    {
        if( arr.length == index )
        {
            return -1;
        }

        else if( arr[ index ] == k  )
        {
            return index;
        }

        return getFirst( arr, index + 1, k );

    }
}