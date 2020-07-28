import java.util.*;

public class fact{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int fact = FACT( n );

        System.out.println( fact );
        System.out.println();
    }

    public static int FACT( int n )
    {
        if( n == 0 )
        {
            return 1;
        }
        if( n == 1 )
        {
            return 1;
        }
        return n * FACT( n - 1 );
        // return ans;
    }
}