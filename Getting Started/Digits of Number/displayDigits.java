import java.util.*;

public class displayDigits{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );

        int n = scn.nextInt();
        int temp = n;
        int digits = 0;
        while( n > 0 )
        {
            digits++; 
            n = n / 10;
        }
        digits--;
        n = temp;
        while( digits >= 0 )
        {
             int divisor = (int)(Math.pow(10,digits));
             digits--;
             int d = n / divisor;
             n = n%divisor;
             System.out.println( d );
        }
    }
}