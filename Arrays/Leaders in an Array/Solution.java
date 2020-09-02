import java.util.Scanner;
import java.util.Stack;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++ )
        {
            arr[i] = scn.nextInt();
        }
        int[] ans = leadersInArray( arr );
        for( int ele : ans )
        {
            System.out.print( ele + " ");
        }       
    }

    public static int[] leadersInArray( int[] arr )
    {
        int max = -(int)1e8;
        Stack<Integer> st = new Stack<>();
        for( int i = arr.length - 1; i >= 0; i-- )
        {
            if( arr[i] > max )
              {
                  max = arr[i];
                  st.push( max );
              }
        }

        int[] ans = new int[st.size()];
        int idx = st.size() - 1;
        while( st.size() != 0 )
        {
            ans[idx--] = st.pop(); 
        }
        return ans;
    }

}