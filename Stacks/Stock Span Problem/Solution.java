import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++ )
        {
            arr[i] = scn.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push( 0 );
        for( int i = 1; i < arr.length; i++ )
        {
            while( st.size() != 0 && arr[st.peek()] <= arr[i] )
            {
                st.pop();
            }
            if(st.size() == 0)
            {
                st.push(i);
                ans[i] = i+1;
            }
            else{
                    int index = st.peek();
                    ans[i] = i - index;
                    st.push(i);
                }
            }
        
        

        for( int ele : ans )
        {
            System.out.print( ele + " ");
        }
    }
}