import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++ )
        {
            arr[i] = scn.nextInt();
        }

        int[] ans = new int[ arr.length ];
        Stack<Integer> st = new Stack<>();
        ans[ arr.length - 1] = arr[arr.length-1];

        for( int i = arr.length - 1; i >= 0; i-- )
        {
            while( st.size() != 0 && st.peek() <= arr[i] )
            {
                st.pop();
            }
            if( st.size() == 0 )
            {
                ans[i] = -1;
            }
            else
            {
                ans[i] = st.peek();
            }
            st.push( arr[ i ] );
        }

        for( int ele :  ans )
        {
            System.out.println( ele + " ");
        }
    }
}