import java.io.*;
import java.util.*;

public class Solution {

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner( System.in );
      int n = scn.nextInt();

      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = scn.nextInt();
      }

      int k = scn.nextInt();
      solve(n,arr,k);
    }

    public static void solve( int n, int[] arr, int k )
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while( pq.size() < k && i < arr.length )
        {
            pq.add( arr[i] );
            i++;
        }

        while( i < arr.length )
        {
            if( pq.peek() < arr[i] )
            {
                pq.remove();
                pq.add( arr[i] );
            }
            i++;
        }

        System.out.println(pq);

        ArrayList<Integer> ans = new ArrayList<>();
        while( pq.size() > 0 )
        {
            ans.add( pq.remove() );
        }

        System.out.println( ans );
    }

}