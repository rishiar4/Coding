public class Solution{
    public static void main(String[] args) {
        int arr[] = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };
        int n = arr.length;
        
        int[] dp_lis = new int[n];
        int[] dp_lds = new int[n];

        for( int i = 0; i < n; i++ ){
            dp_lis[i] = arr[i];
            for( int j = i - 1; j >= 0; j-- ){
                if( arr[i] > arr[j] ){
                    dp_lis[i] = Math.max( dp_lis[i], dp_lis[j] + arr[i] );
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            dp_lds[i] = arr[i];
            for( int j = i + 1; j < n; j++ ){
                if( arr[i] > arr[j] ){
                    dp_lds[i] = Math.max( dp_lds[i], dp_lds[j] + arr[i]);
                }
            }
        }

        int maxSum = -(int)1e9;
        for( int i = 0; i < n; i++ ){
            maxSum = Math.max( maxSum, dp_lds[i] + dp_lis[i] - arr[i] );
        }

        System.out.println( maxSum );
    }
}