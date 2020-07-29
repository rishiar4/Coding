import java.util.*;

public class displayArrayReverse{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++ )
        {
            arr[i] = scn.nextInt();
        }

        display( arr, 0 );
    }

    public static void display( int[] arr, int index ){
        if( index == arr.length )
        {
            return;
        }
        display( arr, index + 1 );
        System.out.print( arr[ index ] + " ");
    }
}