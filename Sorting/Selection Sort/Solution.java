public class Solution{
    public static void main(String[] args) {
        int[] arr = {20,10,5,15,78};

        for( int i = 0; i < arr.length  ; i++ )
        {
            int idxMax = 0;
            for( int j = 1; j < arr.length - i; j++ )
            {
                if( arr[idxMax] < arr[j] )
                {
                    idxMax = j;
                }
            }
            int temp = arr[idxMax];
            arr[idxMax] =  arr[arr.length-1-i];
            arr[ arr.length-1-i ] = temp;
        }
        for( int ele : arr )
        {
            System.out.print( ele + " ");
        }
    }
}