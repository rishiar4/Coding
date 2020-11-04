class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] dp = new int[n];
        
        Arrays.sort( envelopes, (a,b) -> {
            if( a[0] == b[0] ) return b[1] - a[1];
            else return a[0] - b[0];
        });

        int maxLen = 0;
        for( int i = 0; i < n; i++ ){
            dp[i] = 1;
            for( int j = i - 1; j >= 0; j-- ){
                if( envelopes[i][1] > envelopes[j][1] ){
                    dp[i] = Math.max( dp[i], dp[j] + 1 );
                }
            }
            maxLen = Math.max( maxLen, dp[i]);
        }
        return maxLen;
    }
}