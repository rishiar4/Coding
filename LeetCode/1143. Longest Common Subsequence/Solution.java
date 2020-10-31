class Solution {
    public int LCSR( String text1, String text2, int n, int m ){
        if( n == 0 || m == 0 ) return 0;

        if( text1.charAt( n - 1 ) == text2.charAt( m - 1 ) )
            return LCSR( text1, text2, n - 1, m - 1) + 1;
        else return Math.max( LCSR( text1, text2, n - 1, m), LCSR( text1, text2, n, m - 1) );   
    }

    public int LCS_MEM( String text1, String text2, int n, int m, int[][] dp ){
        if( n == 0 || m == 0 ) return dp[n][m] = 0;

        if( dp[n][m] != 0 ) return dp[n][m];
        if( text1.charAt( n - 1 ) == text2.charAt( m - 1 ) )
            return dp[n][m] = LCS_MEM( text1, text2, n - 1, m - 1, dp) + 1;
        else return dp[n][m] =  Math.max( LCS_MEM( text1, text2, n - 1, m, dp), LCS_MEM( text1, text2, n, m - 1, dp) );
    }

    public int LCS_DP( String text1, String text2,int N, int M, int[][] dp ){
        for( int n = 0; n <= N; n++ ){
            for( int m = 0; m <= M; m++ ){
                if( n == 0 || m == 0 ){
                    dp[n][m] = 0;
                    continue;
                }

                if( text1.charAt( n - 1 ) == text2.charAt( m - 1 ) )
                    dp[n][m] = dp[n-1][m-1] + 1; // LCS_MEM( text1, text2, n - 1, m - 1, dp) + 1;
                else dp[n][m] = Math.max( dp[n-1][m], dp[n][m-1] );  //Math.max( LCS_MEM( text1, text2, n - 1, m, dp), LCS_MEM( text1, text2, n, m - 1, dp) );
            }
        }
        return dp[N][M];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // return LCSR( text1, text2, n, m );
        int[][] dp = new int[ n + 1 ][ m + 1 ];
        // return LCS_MEM( text1, text2, n, m, dp );
        return LCS_DP( text1, text2, n, m, dp);
    }
}