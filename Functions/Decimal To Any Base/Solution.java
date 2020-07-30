import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int dec = scn.nextInt();
        int base = scn.nextInt();

        int ans = decimalToAnyBase( dec, base );
        System.out.println( ans );
    }

    public static int decimalToAnyBase( int dec, int base )
    {
        int ans = 0;
        int pow = 1;
        while( dec > 0 )
        {
            int rem = dec % base;
            ans = ans + rem*pow;
            pow = pow*10;
            dec = dec / base;
        }
        return ans;
    }
}