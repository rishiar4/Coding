import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < arr.length; i++ )
        {
            arr[i] = scn.nextInt();
        }

        int sum = 0;
        int[] pSum = new int[ arr.length ];
        for( int i = 0; i < arr.length; i++ )
        {
            pSum[i] += sum + arr[i];
            sum = pSum[i];
        }

        System.out.println( getSum( pSum, 0, 2 ) );
        System.out.println( getSum( pSum, 1, 3 ) );
        System.out.println( getSum( pSum, 3, 7 ) );

        for( int ele : pSum ) System.out.print( ele + " ");

    }

    public static int getSum( int[] pSum, int l, int h )
    {
        if( l == 0 ) return pSum[ h ];

        else
         return pSum[h] - pSum[ l - 1 ];
    }
}