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

        int pos = lSearch( arr, k );
        System.out.println( pos );
    }

    public static int lSearch( int[] arr, int k )
    {
        int pos = -1;
        for( int i = 0; i < arr.length; i++ )
        {
            if( arr[i] == k )
            {
                pos = i;
                break;
            }
        }
        return pos;
    }
}