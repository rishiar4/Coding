import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean b = checkBalanced( str );
        System.out.println( b );
    }

    public static boolean checkBalanced( String str )
    {
        Stack<Character> st = new Stack<>();

        for( int i = 0; i < str.length(); i++ )
        {
            char ch = str.charAt( i );
            if( ch == '(' || ch == '[' || ch == '{' )
            {
                st.push( ch );
            }
            else if( ch ==')' || ch == ']' || ch == '}' )
            {
                if( ch == ')' )
                {
                    if( st.peek() == '(' )
                    {
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else if( ch == ']' )
                {
                    if( st.peek() == '[' )
                    {
                        st.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
                else if( ch == '}' )
                {
                    if( st.peek() == '{' )
                    {
                        st.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        } 

        if( st.size() != 0 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}