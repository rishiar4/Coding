class Solution {
    public int minDistanceMem( String word1, String word2, int n, int m, int[][] dp ){
        if( n == 0 || m == 0 ){
            return dp[n][m] = n != 0 ? n : m;
        }

        if( dp[n][m] != 0 ) return dp[n][m];
        if( word1.charAt(n-1) == word2.charAt(m-1) ) dp[n][m] = minDistanceMem( word1, word2, n-1, m-1, dp);
        else{
            int insert = minDistanceMem( word1, word2, n, m - 1, dp );
            int delete = minDistanceMem( word1, word2, n - 1, m, dp );
            int replace = minDistanceMem( word1, word2, n - 1 , m - 1, dp );

            dp[n][m] = 1 + Math.min( insert, Math.min( delete, replace ) );
        }
        return dp[n][m];
    }

    public int minDistanceDP( String word1, String word2, int N, int M, int[][] dp ){
        for( int n = 0; n <= N; n++ ){
            for( int m = 0; m <= M; m++ ){
                if( n == 0 || m == 0 ){
                    dp[n][m] = n != 0 ? n : m;
                    continue;
                }
        
                if( word1.charAt(n-1) == word2.charAt(m-1) ) dp[n][m] = minDistanceMem( word1, word2, n-1, m-1, dp);
                else{
                    int insert = dp[n][m-1]; // minDistanceMem( word1, word2, n, m - 1, dp );
                    int delete = dp[n-1][m]; //minDistanceMem( word1, word2, n - 1, m, dp );
                    int replace = dp[n-1][m-1]; //minDistanceMem( word1, word2, n - 1 , m - 1, dp );
        
                    dp[n][m] = 1 + Math.min( insert, Math.min( delete, replace ) );
                }   
            }
        }
        return dp[N][M];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        // return minDistanceMem( word1, word2, n, m, dp);
        return minDistanceDP(word1, word2,n,m,dp);
    }
}