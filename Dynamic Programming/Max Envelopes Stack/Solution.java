import java.util.Arrays;
public class Solution{
    public static void main(String[] args) {
        int[][] arr = {{3, 6}, {5, 4}, {4, 8}, {6, 9}, {10, 7}, {12, 12}};
        Arrays.sort( arr, (a,b) -> { 
            if( a[0] == b[0] ) return a[1] - b[1];
            else return a[0] - b[0];
        });

        for( int[] d : arr ){
            for( int ele : d ){
                System.out.print( ele + " ");
            }
            System.out.println();
        }

        int n = arr.length;
        int[] dp = new int[n];

        int maxLen = 0;
        for( int i = 0; i < n; i++ ){
            dp[i] = 1;
            for( int j = i - 1; j >= 0; j-- ){
                if( arr[i][1] > arr[j][1] ){
                    dp[i] = Math.max( dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max( dp[i], maxLen );
        }

        System.out.println( maxLen );
    }
}