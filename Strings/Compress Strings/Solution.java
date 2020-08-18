import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        String str = scn.nextLine();

        compress1( str );
        System.out.println();
        compress2( str );
    }

    public static void compress1( String str )
    {
        for( int i = 0; i < str.length() - 1; i++ )
        {
            char ch1 = str.charAt( i );
            char ch2 = str.charAt( i + 1 );

            if( ch1 != ch2 )
            {
                System.out.print( ch1 );
            }
        }
        System.out.print( str.charAt( str.length() - 1 ) );
    }

    public static void compress2( String str )
    {
        int count = 0;
        for( int i = 0; i < str.length() - 1; i++ )
        {
            char ch1 = str.charAt( i );
            char ch2 = str.charAt( i + 1 );

            if( ch1 != ch2 )
            {
                count++;
                System.out.print( ch1 +""+count );
                count = 0;
            }
            else
            {
                count++;
            }
        }
        System.out.print( str.charAt(  str.length()-1 ) );
        if( count > 0 )
        {
            System.out.print( count + 1 );
        }
    }

}