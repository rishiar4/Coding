import java.util.*;

public class displayArray{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++ )
        {
            arr[i] = scn.nextInt();
        }

        print(arr,0);
    }

    public static void print( int[] arr, int index )
    {
        if( index == arr.length )
        {
            return;
        }
        System.out.print(arr[ index ] + " ");
        print(arr, index + 1 );
    }
}