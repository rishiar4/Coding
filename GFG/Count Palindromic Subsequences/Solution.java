    //https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
    class GfG
    {
        int countPSMem( String str, int i, int j, int[][] dp ){
            if( i >= j ){
                return dp[i][j] = ( i == j ) ? 1 : 0;
            }

            if( dp[i][j] != 0 ) return dp[i][j];

            int x = countPSMem( str, i + 1, j - 1, dp);
            int y = countPSMem( str, i, j - 1, dp );
            int z = countPSMem( str, i + 1, j, dp );

            if( str.charAt(i) == str.charAt(j) ) dp[i][j] = ( x + 1 ) + ( y + z - x );
            else dp[i][j] = ( y + z - x );

            return dp[i][j];
        }

        int countPSDP( String str, int I, int J, int[][] dp ){
            for( int gap = 0; gap < str.length(); gap++ ){
                for( int i = 0, j = gap; j < str.length(); j++, i++ ){
                    if( i >= j ){
                        dp[i][j] = ( i == j ) ? 1 : 0;
                        continue;
                    }
        
                    int x = dp[i+1][j-1]; // countPSMem( str, i + 1, j - 1, dp);
                    int y = dp[i][j-1]; //countPSMem( str, i, j - 1, dp );
                    int z = dp[i+1][j]; //countPSMem( str, i + 1, j, dp );
        
                    if( str.charAt(i) == str.charAt(j) ) dp[i][j] = ( x + 1 ) + ( y + z - x );
                    else dp[i][j] = ( y + z - x );
        
                }
            }
            return dp[I][J];
        }
    
        int countPS(String str)
        {
            int n = str.length();
            int[][] dp = new int[n+1][n+1];
            // return countPSMem( str, 0, n - 1, dp );
            return countPSDP( str, 0, n - 1, dp);
        }
    }