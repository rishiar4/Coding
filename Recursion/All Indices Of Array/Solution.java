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
        int[] ans = printIndices( arr, 0 , k, 0 );
        for( int ele : ans )
            System.out.print( ele + " ");
    }
    
    public static int[] printIndices( int[] arr , int index, int k, int size )
    {
        if( arr.length == index )
        {
            int[] baseAns = new int[size];
            return baseAns;
        }
        if( arr[ index ] == k  )
        {
            size = size + 1;
        }
        int[] ans =  printIndices( arr, index + 1, k, size );
        if( arr[index] == k )
        {
            ans[size-1] = index;
        }
        return ans;
    }
}