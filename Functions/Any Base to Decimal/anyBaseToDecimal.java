import java.util.*;

public class anyBaseToDecimal{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int base = scn.nextInt();

        int ans = convertToBase(number, base);

        System.out.println( ans );
    }

    public static int convertToBase( int number, int base )
    {
        int ans = 0;
        int pow = 1;
        while( number > 0 )
        {
            int rem = number % 10;
            ans+= rem*pow;
            number = number / 10;
            pow*=base;
        }
        return ans;
    }
}