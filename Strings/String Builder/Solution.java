import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        String str = scn.nextLine();
        StringBuilder sb = new StringBuilder( str );

        System.out.println( sb );

        sb.append("g");

        System.out.println( sb );

        sb.append("ll");
        sb.insert(1,"@");
        // sb.setCharAt(1,"l");
        sb.deleteCharAt(1);

        sb.append(";");
        System.out.println( sb );


    }
}