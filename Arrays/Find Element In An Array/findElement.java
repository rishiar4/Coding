import java.util.*;

public class findElement{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();
        
        int index = findAt(arr,d);

        System.out.println( index );
    }

    public static int findAt(int[] arr, int d )
    {
        int index = -1;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == d )
            {
              index = i;
              return index;
            }
        }
        return index;
    }

}