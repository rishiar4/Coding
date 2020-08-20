import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push( 10 );
        st.push( 30 );
        st.push( 100 );
        st.push( 150 );

        System.out.println( st );

        st.pop();

        System.out.println( st );

        System.out.println( st.size() );

        System.out.println( st.peek() );

        System.out.println( st.isEmpty() );

        while( st.isEmpty() != true )
        {
            System.out.println( st.pop() );
        }

        System.out.println( st.isEmpty() );



    }
}