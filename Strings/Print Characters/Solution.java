import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        String str = scn.nextLine();

        for( int i = 0; i < str.length(); i++ )
        {
            System.out.println( str.charAt(i) );
        }
    }
}