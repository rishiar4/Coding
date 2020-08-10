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
        printIndices( arr, 0 , k );
    }
    
    public static void printIndices( int[] arr , int index, int k )
    {
        if( arr.length == index )
        {
            return;
        }
        if( arr[ index ] == k  )
        {
            System.out.println( index );
        }
        
        printIndices( arr, index + 1, k );
        
    }
}