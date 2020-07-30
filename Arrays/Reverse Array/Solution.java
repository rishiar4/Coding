import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[ n ];

        for( int i = 0; i < arr.length; i++ )
        {
            arr[i] = scn.nextInt();
        }

        reverse( arr );
    }
    public static void display( int[] arr )
    {
        for( int i = 0; i < arr.length; i++ )
        {
            System.out.print( arr[i] + " " );
        }
    }
    // 1 4 5 3 5 
    public static void reverse( int[] arr )
    {
        int j = arr.length - 1;
        for( int i = 0; i < arr.length/2 ; i++ )
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        display( arr );
    }
}