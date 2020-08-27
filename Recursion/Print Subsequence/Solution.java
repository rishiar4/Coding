import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        
        printSS(s,"");
    }

    public static void printSS(String ques, String ans) {
        if( ques.length() == 0 )
        {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        printSS( roq, ans );
        printSS( roq, ans + ch  );
    }

}