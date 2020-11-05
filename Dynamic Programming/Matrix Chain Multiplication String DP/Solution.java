import java.util.Arrays;
public class Solution{

    public static int MCM_DP( int[] arr, int SI, int EI, int[][] dp, String[][] sdp ){
        int n = arr.length;
        for( int gap = 1; gap < n; gap++ ){
            for( int si = 0, ei = gap; ei < n; ei++,si++ ){
                if( si + 1 == ei ){
                    dp[si][ei] = 0;
                    sdp[si][ei] = (char)(si + 'A') +"";
                    continue;
                }
        
                int minCost = (int)1e9;
                for( int cut = si + 1; cut < ei; cut++ ){
                    int lTree = dp[si][cut]; //  MCM_MEM( arr, si, cut, dp );
                    int rTree = dp[cut][ei]; //  MCM_MEM( arr, cut, ei, dp );
        
                    int cMultiplication = lTree + ( arr[si] * arr[cut] * arr[ei] ) + rTree;
                    if( minCost > cMultiplication ){
                        minCost = cMultiplication;
                        sdp[si][ei] = "(" + sdp[si][cut] + sdp[cut][ei] + ")";
                    }
                } 
        
                dp[si][ei] = minCost;   
            }
        }
        return dp[SI][EI];
    }

    public static void MCM(){
        int[] arr = { 10, 20, 30, 40, 30 };
        int n = arr.length;

        int[][] dp = new int[n][n];
        for( int[] d : dp ) Arrays.fill( d, -1);

        String[][] sdp = new String[n][n];
        for( String[] sd : sdp ) Arrays.fill( sd, "");

        // int ans = MCM_MEM( arr, 0, n - 1, dp );

        int ans = MCM_DP( arr, 0, n - 1, dp, sdp );

        System.out.println( ans );
        System.out.println( sdp[0][n-1] );
    }
    public static void main(String[] args) {
        MCM();
    }
}