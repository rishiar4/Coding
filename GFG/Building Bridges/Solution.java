import java.util.Arrays;
public class Solution{
    public static void main(String[] args) {
        int[][] arr = { { 8,1}, { 1,2}, { 4,3}, { 3,4}, { 5,5}, { 2,6}, { 6,7}, { 6, 8}, { 7,8} };
        // int[][] arr = {{6, 2}, {4, 3}, {2, 6}, {1, 5}};
        
        Arrays.sort( arr, (a,b) -> { 
            if( a[0] == b[0] ) return b[1] - a[1];
            else return a[0] - b[0];
        });

        for( int[] d : arr ){
            for( int a : d ){
                System.out.print( a + " ");
            }
            System.out.println();
        }
        int n = arr.length;
        int[] dp = new int[n];
        int maxStack = 0;
        for( int i = 0; i < n; i++ ){
            dp[i] = 1;
            for( int j = i - 1; j >= 0; j-- ){
                if( arr[i][1] > arr[j][1] ){
                    dp[i] = Math.max( dp[i], dp[j] + 1);
                }
            }
            maxStack = Math.max( maxStack, dp[i] ); 
        }
        System.out.println( maxStack );
    }
}