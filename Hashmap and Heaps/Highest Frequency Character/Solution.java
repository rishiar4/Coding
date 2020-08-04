import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );

        HashMap<Character, Integer> hm = new HashMap<>();
        String str = scn.nextLine();

        for( int i = 0; i < str.length(); i++ )
        {
            char ch = str.charAt(i);

            if( hm.containsKey(ch) == true )
            {
                int val = hm.get( ch );

                val++;
                hm.put( ch, val );
            }  
            else
            {
                hm.put( ch, 1 );
            }
        }

        char ch = str.charAt(0);
        int max = hm.get( ch );

        for( int i = 1; i < str.length(); i++ )
        {
            char c = str.charAt( i );

            if( max < hm.get(c))
            {
                max = hm.get(c);
                ch = c;
            }
        }
        System.out.println( ch );
    }
}