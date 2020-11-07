import java.util.Arrays;
public class Solution{
    public static void main(String[] args) {
        int[][] ar = {{3, 6}, {5, 4}, {4, 8}, {6, 9}, {10, 7}, {12, 12}};
        Arrays.sort( ar, (a,b) -> { 
            if( a[0] == b[0] ) return a[1] - b[1];
            else return a[0] - b[0];
        });

        for( int[] d : ar ){
            for( int ele : d ){
                System.out.print( ele + " ");
            }
            System.out.println();
        }

        int n = ar.length;
        int[] dp = new int[n];

        int maxLen = 0;
        for( int i = 0; i < n; i++ ){
            dp[i] = 1;
            for( int j = i - 1; j >= 0; j-- ){
                if( ar[i][1] > ar[j][1] ){
                    dp[i] = Math.max( dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max( dp[i], maxLen );
        }

        System.out.println( maxLen );
    }
}