import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        String str = scn.nextLine();

        System.out.println( modify( str ) );
    }
    public static String modify( String str )
    {
        StringBuilder sb = new StringBuilder( str );

        for( int i = 0; i < sb.length(); i++ )
        {
            char ch = sb.charAt( i );
            if( i % 2 == 0 )
            {
                ch = ( char )( ch + 1 );
            }
            else
            {
                ch = ( char )( ch - 1 );
            }
            sb.setCharAt(i,ch);
        }

        return sb.toString();

    }
}