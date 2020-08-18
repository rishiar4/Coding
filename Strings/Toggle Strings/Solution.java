import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        String str = scn.nextLine();
        
        System.out.println( toggle( str ) );
    }

    public static String toggle( String str )
    {
        StringBuilder sb = new StringBuilder( str );

        for( int i = 0; i < sb.length(); i++ )
        {
            char ch = sb.charAt( i );

            if( ch >= 'a' && ch <= 'z' )
            {
                ch = (char)(  ch - 'a' + 'A' );
            }
            else
            {
                ch = (char)(  ch + 'a' - 'A');

            }
            sb.setCharAt( i , ch );
        }
        return sb.toString();
    }
}