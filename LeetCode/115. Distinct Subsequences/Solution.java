class Solution {
    public int numDistinctR( String s, String p, int n, int m){
        if( m == 0 ){
            return 1;
        }
        
        if( n < m ){
            return 0;
        }

        int count = 0;

        if( s.charAt( n - 1) == p.charAt( m - 1) ){
            count += numDistinctR( s, p, n - 1, m - 1 );
            count += numDistinctR( s, p, n - 1, m );
        }else{
            count += numDistinctR( s, p, n - 1, m );
        }
        return count;
    }

    public int numDistinctMem( String s, String p, int n, int m, int[][] dp ){
        if( m == 0 ){
            return dp[n][m] = 1;
        }
        
        if( n < m ){
            return dp[n][m] = 0;
        }

        if( dp[n][m] != -1 ){
            return dp[n][m];
        }

        int count = 0;

        if( s.charAt( n - 1) == p.charAt( m - 1) ){
            count += numDistinctMem( s, p, n - 1, m - 1, dp );
            count += numDistinctMem( s, p, n - 1, m, dp );
        }else{
            count += numDistinctMem( s, p, n - 1, m, dp );
        }
        return dp[n][m] = count;
    }

    public int numDistinctDP( String s, String p, int N, int M, int[][] dp ){
        for( int n = 0; n <= N; n++ ){
            for( int m = 0; m <= M; m++ ){
                if( m == 0 ){
                    dp[n][m] = 1;
                    continue;
                }
                
                if( n < m ){
                    dp[n][m] = 0;
                    continue;
                }
        
                int count = 0;
        
                if( s.charAt( n - 1) == p.charAt( m - 1) ){
                    count += dp[n-1][m-1]; // numDistinctMem( s, p, n - 1, m - 1, dp );
                    count += dp[n-1][m]; //numDistinctMem( s, p, n - 1, m, dp );
                }else{
                    count += dp[n-1][m]; //numDistinctMem( s, p, n - 1, m, dp );
                }
                dp[n][m] = count;
            }
        }
        return dp[N][M];
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // return numDistinctR( s, t, n, m );
        int[][] dp = new int[ n + 1 ][ m + 1 ];
        for( int[] d : dp ){
            Arrays.fill( d, -1 );
        }
        // return numDistinctMem( s, t, n, m, dp);
        return numDistinctDP( s, t, n, m, dp);
    }
}