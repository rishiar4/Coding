import java.util.*;

public class printDecreasing{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printD( n );
        System.out.println();
    }

    public static void printD( int n )
    {
        if( n == -1 )
        {
            return;
        }
        System.out.print( n + " ");
        printD( n - 1);
    }
}