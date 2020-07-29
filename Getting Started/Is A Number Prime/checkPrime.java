import java.util.*;

public class checkPrime{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        boolean ans = check( n );
        if( ans ) 
        {
            System.out.println("Prime");
        }
        else
        {
            System.out.println(" Not prime ");
        }
    }
    public static boolean check( int n )
    {
        for( int i = 2; i < Math.sqrt( n ); i++ )
        {
            if( n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}