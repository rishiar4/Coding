import java.util.*;

public class printIncreasing{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        printI( n );
        System.out.println();
    }

    public static void printI( int n )
    {
        if( n == -1  )
        {
            return;
        }
        printI( n - 1);
        System.out.print( n + " ");
    }
}