class Solution {
    public int numDecodingsR( String s, int idx ){
        if( idx == s.length() ) return 1;

        int count = 0;

        if( s.charAt(idx) == '0') return 0;
        
        count += numDecodingsR( s, idx + 1);

        if( idx < s.length() - 1 ){
            int ch1 = s.charAt( idx ) - '0';
            int ch2 = s.charAt( idx + 1 ) - '0';

            int num = ch1 * 10 + ch2;
            if( num >= 10 && num <= 26 ){
                count += numDecodingsR( s, idx + 2 );
            }
        }
        return count;
    }

    public int numDecodingsM( String s, int idx, int[] dp ){
        if( idx == s.length() ) return dp[idx] = 1;

        if( dp[ idx ] != -1 ) return dp[idx];

        int count = 0;

        if( s.charAt( idx ) == '0' ) return 0;

        count += numDecodingsM( s, idx + 1, dp );

        if( idx < s.length() - 1 ){
            int ch1 = s.charAt( idx ) - '0';
            int ch2 = s.charAt( idx + 1 ) - '0';
            int num = ch1 * 10 + ch2;
            if( num >= 10 && num <= 26 ){
                count += numDecodingsM( s, idx + 2, dp );
            }
        }
        return dp[ idx ] = count;
    }

    public int numDecodingsDP( String s, int idx, int[] dp){
        for( idx = s.length(); idx >= 0; idx-- ){
            if( idx == s.length() ){
                dp[idx] = 1;
                continue;
            } 

            int count = 0;

            if( s.charAt( idx ) == '0' ) return 0;

            count += dp[ idx + 1 ]; // numDecodingsM( s, idx + 1, dp );

            if( idx < s.length() - 1 ){
                int ch1 = s.charAt( idx ) - '0';
                int ch2 = s.charAt( idx + 1 ) - '0';
                int num = ch1 * 10 + ch2;
                if( num >= 10 && num <= 26 ){
                    count += dp[ idx + 2 ]; // numDecodingsM( s, idx + 2, dp );
                }
            }
            dp[ idx ] = count;
        }
        return dp[0];
    }

    public int numDecodingsOpti( String s ){
        
        int a = 1;
        int b = 0;

        for( int idx = s.length() - 1; idx >= 0; idx-- ){
            int sum = 0;
            char ch = s.charAt(idx);
            if( ch == '0' ) sum = 0;
            else{
                sum = a;
                if( idx < s.length() - 1 ){
                    int num = ( s.charAt(idx) - '0' ) * 10 - ( s.charAt( idx + 1 ) - '0' );
                    if( num >= 10 && num <= 26 ) sum += b;
                }
            }
            
            b = a;
            a = sum;
        }
        return a;    
    }
    
    public int numDecodings(String s) {
     int n = s.length();
     if( n == 0 ) return 0;
    //  return numDecodingsR( s, 0);   
    int[] dp = new int[ n + 1 ];
    Arrays.fill(dp,-1);
    // return numDecodingsM( s, 0, dp );
    return numDecodingsDP( s, 0, dp);
    // return numDecodingsOpti( s );
    }
}