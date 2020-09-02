import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < arr.length; i++ ) arr[i] = scn.nextInt();

        System.out.println( equillibriumPoint( arr ) );
    }

    public static int equillibriumPoint( int[] arr )
    {
        int sum = 0;
        for( int ele : arr ) sum+= ele;
        int lsum = 0;
        for( int ele : arr )
        {
            if( lsum == sum - ele )  return ele;
            lsum += ele;
            sum-= ele;
        }
        return -1;
    }
}