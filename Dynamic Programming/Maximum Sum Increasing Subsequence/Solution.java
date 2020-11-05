import java.util.Scanner;
public class Solution{
    public static int maximumSumIncreasing( int[] arr, int[] dp){
        
        int n = arr.length;
        int maxLen = 0;
        for( int i = 0; i < n; i++ ){
            dp[i] = arr[i];
            for( int j = i - 1; j >= 0; j-- ){
                if( arr[i] > arr[j] ){
                    dp[i] = Math.max( dp[i], dp[j] + arr[i] );
                }
            }
            maxLen = Math.max( maxLen, dp[i] );
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        int n = scn.nextInt();
        int[] arr = new int[n];

        for( int i = 0; i < n; i++ ){
            arr[i] = scn.nextInt();
        }
        
        int[] dp = new int[n];

        int ans = maximumSumIncreasing( arr, dp );

        System.out.println( ans );
    }
}