import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n1 = scn.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for( int i = 0; i < n1; i++ )
        {
            int val = scn.nextInt();
            if( hm.containsKey( val ) == true )
            {
                hm.put( val, hm.get( val ) + 1 );
            }
            else
            {
                hm.put( val, 1 );
            }
        }
        
        int n2 = scn.nextInt();
        for( int i = 0; i < n2; i++ )
        {
            int val = scn.nextInt();
            if( hm.containsKey( val ) == true )
            {
                System.out.println( val );
                hm.put( val, hm.get( val ) - 1 );
            }
        }
    }
}