import java.util.*;

public class Fib{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int f = 0, s = 1;
        int t = f + s;

        for( int i = 0; i < n; i++ )
        {
            System.out.println( f );
            f = s;
            s = t;
            t = f + s;
        }
    }
}