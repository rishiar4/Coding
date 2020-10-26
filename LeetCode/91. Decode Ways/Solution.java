
    class Solution {
    
        public void print( int[] dp)
        {
            for( int ele : dp )
            {
                System.out.print( ele + " ");
            }
        }
        public int numDecodingsRecursive( String s, int idx ){
            if( idx == s.length() ) return 1;
            
            int count = 0;
            
            if( s.charAt(idx) == '0' ) return 0;
            
            count+= numDecodingsRecursive( s, idx + 1);

            if( idx < s.length() - 1 )
            {
                int ch1 = s.charAt(idx) - '0';
                int ch2 = s.charAt( idx + 1 ) - '0';

                int chT = ch1*10 + ch2;
                if( chT >= 10 && chT <= 26 )
                {
                    count += numDecodingsRecursive( s, idx + 2 );
                }
            }
            return count;
        }

        public int numDecodingsMem( String s, int idx, int[] dp )
        {
            if( idx == s.length() ) return dp[idx] = 1;

            if( dp[idx] != -1 ) return dp[idx];
            
            int count = 0;
            
            if( s.charAt(idx) == '0' ) return 0;
            
            count+= numDecodingsMem( s, idx + 1, dp);

            if( idx < s.length() - 1 )
            {
                int ch1 = s.charAt(idx) - '0';
                int ch2 = s.charAt( idx + 1 ) - '0';

                int chT = ch1*10 + ch2;
                if( chT >= 10 && chT <= 26 )
                {
                    count += numDecodingsMem( s, idx + 2, dp );
                }
            }
            return dp[idx] = count;          
        }
        
        public int numDecodingsDP( String s, int idx, int[] dp)
        {
            for( idx = s.length() ; idx >= 0; idx-- )
            {
                if( idx == s.length() ) {
                    dp[idx] = 1;
                    continue;
                }
                
                int count = 0;
                
                if( s.charAt(idx) == '0' ) { 
                    dp[idx] =  0;
                    continue;
                }
                
                count+= dp[idx+1]; // numDecodingsMem( s, idx + 1, dp);
    
                if( idx < s.length() - 1 )
                {
                    int ch1 = s.charAt(idx) - '0';
                    int ch2 = s.charAt( idx + 1 ) - '0';
    
                    int chT = ch1*10 + ch2;
                    if( chT >= 10 && chT <= 26 )
                    {
                        count +=  dp[idx+2]; //numDecodingsMem( s, idx + 2, dp );
                    }
                }
                dp[idx] = count;              
            }
            return dp[0];

        }

        public int numDecodings(String s) {
            if( s.length() == 0 ) return 0;
            // return numDecodingsRecursive( s, 0 );
            int[] dp = new int[s.length() + 1];
            // Arrays.fill(dp,-1);
            // int ans =  numDecodingsMem( s, 0, dp  );
            // print(dp);
            // return ans;
            return numDecodingsDP( s, 0, dp);
        }
    }