public class StringQuestions{

    // 647. Palindromic Substrings
    public int countSubstrings(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        
        int count = 0;
        for( int gap = 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; j++, i++){
                if( gap == 0 ) dp[i][j] = true;
                else if( gap == 1 )
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                else 
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i+1][j-1];
                
                if( dp[i][j] )
                    count++;
            }
        }

        return count;
    }

    // 5. Longest Palindromic Substring
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int len = 0, si = 0, ei = 0;
        // starting index, ending index

        for( int gap = 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; j++, i++){
                if( gap == 0 )
                    dp[i][j] = 1;
                else if( gap == 1 && s.charAt(i) == s.charAt(j) )
                    dp[i][j]  = 2;
                else if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0)
                    dp[i][j] = dp[i+1][j-1] + 2;

                if( dp[i][j] > len){
                    len = dp[i][j];
                    si = i;
                    ei = j;
                }
            }
        }
        return s.substring( si, ei + 1 );
    }

    // 516. Longest Palindromic Subsequence
    public int longestPalindromeSubseq( String s, int i, int j, int[][] dp){

        if( i > j || i == j  )
            return dp[i][j] = ( i == j ) ? 1 : 0;

        if( dp[i][j] != 0)
            return dp[i][j];
        
        if( s.charAt(i) == s.charAt(j) )
            dp[i][j] = longestPalindromeSubseq( s, i + 1, j - 1, dp) + 2;
        else 
            dp[i][j] = Math.max( longestPalindromeSubseq( s, i + 1, j, dp), longestPalindromeSubseq( s, i, j - 1, dp) );
        
        return dp[i][j];
    }

    public int longestPalindromeSubseqDP( String s, int I, int J, int[][] dp){
        int n = s.length();
        for( int gap = 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; j++, i++){
            if( i > j || i == j  ){
                dp[i][j] = ( i == j ) ? 1 : 0;
                continue;
            }

            if( s.charAt(i) == s.charAt(j) )
                dp[i][j] = dp[ i + 1 ][ j - 1]+2; // longestPalindromeSubseq( s, i + 1, j - 1, dp) + 2;
            else 
                dp[i][j] = Math.max( dp[i+1][j], dp[i][j-1] ); //Math.max( longestPalindromeSubseq( s, i + 1, j, dp), longestPalindromeSubseq( s, i, j - 1, dp) );
            
            }
        }
        return dp[I][J];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // int ans = longestPalindromeSubseq( s, 0, n - 1, dp);
        int ans = longestPalindromeSubseqDP( s, 0, n - 1, dp);
        return ans;
    }


}