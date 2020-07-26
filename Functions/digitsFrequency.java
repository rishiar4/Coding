import java.util.*;

public class digitsFrequency{
public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int d = scn.nextInt();

    int frequency = getFrequency( n, d );

    System.out.println(frequency);

}
public static int getFrequency( int num, int d )
{
    int frequency = 0;
    while( num > 0 )
    {
        int digit = num % 10;
        if( digit == d )
        {
            frequency++;
        } 
        num = num / 10;
    }
    return frequency;
 }
}