import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner( System.in );
        String str = scn.next();
        
        printKPC( str,0, "" );
        
    }
    static String[] words = {".;", "abc", "def", "ghi", "jkl", "mno","pqrs", "tu", "vwx", "yz"};
    
    public static void printKPC(String str,int idx, String ans) {
        
        if( str.length() == idx )
        {
            System.out.println( ans );
            return;
        }
        int num1 = str.charAt( idx ) - '0' ;
        String word = words[ num1 ];
        
        for( int i = 0; i < word.length(); i++ )
        {
            printKPC( str, idx+1, ans + word.charAt(i) );
        }
        
    }

}