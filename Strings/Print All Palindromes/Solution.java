import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        String str = scn.nextLine();

        for( int i = 0; i < str.length(); i++ )
        {
            for( int j = i + 1; j <= str.length(); j++ )
            {
                String ss = str.substring( i,j );
                boolean b = isPalindrome( ss );
                if( b )
                {
                    System.out.println( ss );
                }
            }
        }
    }

    public static boolean isPalindrome( String str )
    {
        int left = 0, right = str.length() - 1;

        while( left <= right )
        {
            if( str.charAt( left ) != str.charAt( right ) )
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}