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

        int[] ans = sortK( arr, k );

        for( int i = 0; i < arr.length; i++ )
        {
            System.out.print( arr[i] + " ");
        }
    } 

    public static int[] sortK( int[] arr, int k )
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while( pq.size() < k && i < arr.length )
        {
            pq.add( arr[ i ] );
            i++;
        }
        int oIndex = 0;
        while( i < arr.length )
        {
            arr[ oIndex ] = pq.remove();
            pq.add( arr[i] );
            oIndex++;
            i++;
        }

        while( pq.size() > 0 )
        {
            arr[ oIndex ] = pq.remove();
            oIndex++; 
        }

        return arr;
    } 
}