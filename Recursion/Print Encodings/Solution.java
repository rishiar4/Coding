import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings( str , "" );
    }

    public static void printEncodings(String ques, String ans ) {
        
        if( ques.length() == 0 )
        {
            System.out.println( ans );
            return;
        }
        
        int num1 = ques.charAt(0) - '0';
        if( num1 == 0 ) return;
        String roq = ques.substring(1);
        
        printEncodings( roq, ans + (char)(num1 + 'a' - 1) );
        
        if( ques.length() > 1 )
        {
            int num2 = num1 * 10 + ( ques.charAt(1) - '0' );
            if( num2 >= 10 && num2 <= 26 )
            {
                printEncodings( ques.substring(2), ans + (char)(num2 + 'a' - 1) );
            }
        }
        
        
    }

}