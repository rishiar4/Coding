public class Solution{
    
    public static int LIS(int[] arr, int[] dp){
        int n = arr.length;

        int maxLen = 0;
        for( int i = 0; i < n; i++ ){
            dp[i] = 1;
            for( int j = i - 1; j >= 0; j-- ){
                if( arr[i] > arr[j] ){
                    dp[i] = Math.max( dp[i], dp[j] + 1 );
                }
            }
            maxLen = Math.max( maxLen, dp[i] );
        }
        return maxLen;
    }

    public static int LDS(int[] arr, int[] dp){
        int n = arr.length;

        int maxLen = 0;
        for( int i = n - 1; i >= 0; i-- ){
            dp[i] = 1;
            for( int j = i + 1; j < n; j++ ){
                if( arr[i] > arr[j] ){
                    dp[i] = Math.max( dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max( maxLen, dp[i] );
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 14};

        int n = arr.length;

        int[] dpLIS = new int[n];
        int[] dpLDS = new int[n];

        LIS( arr, dpLIS );
        LDS( arr, dpLDS );

        int maxLen = 0;
        for( int i = 0; i < n; i++ ){
            maxLen = Math.max( maxLen, dpLDS[i] + dpLIS[i] - 1 );
        }

        System.out.println( maxLen );
    }
}