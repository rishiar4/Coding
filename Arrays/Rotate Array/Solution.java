import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        rotate(arr, k);
        
    }
    public static void display( int[] arr )
    {
        for( int i = 0 ; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void rotatte( int[] arr, int low, int high )
    {
        while( low <= high )
        {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void rotate( int[] arr, int k )
    {
        k = k % arr.length;
        if( k < 0 ) k = k + arr.length;
        rotatte( arr, 0, k - 1 );
        rotatte( arr, k, arr.length - 1 );
        rotatte( arr, 0, arr.length - 1 );
        display(arr);
    }
}