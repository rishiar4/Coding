import java.util.Arrays;
import java.util.LinkedList;
public class l002{
    
    public static void print( int[] arr ){
        for( int a : arr ){
            System.out.print( a + " ");
        }
    }

    public static void print2D( int[][] arr ){
        for( int[] a : arr ){
            print( a );
            System.out.println();
        }
    }

    public static void palindromicSubString( String str, boolean[][] dp){
        int n = str.length();

        for( int gap= 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; i++, j++){
                if( gap == 0 )
                    dp[i][j] = true;
                else if( gap == 1 )
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                else 
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i+1][j-1];
            }
        }

        System.out.println( dp[1][8] );
    }

    public static int countPalindromic( String str, boolean[][] dp){
        int n = str.length();

        int count = 0;
        for( int gap = 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; j++, i++){
                if( gap == 0 )
                    dp[i][j] = true;
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

    public static String longestPalindrome( String str, int[][] dp){
        int si = 0, ei = 0, len = 0;
        int n = str.length();

        for( int gap = 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; j++,i++){
                if( gap == 0 )
                    dp[i][j] = 1;
                else if( gap == 1 && str.charAt(i) == str.charAt(j) )
                    dp[i][j] = 2;
                else if( str.charAt(i) == str.charAt(j) && dp[i+1][j-1] > 0 )
                    dp[i][j] = dp[i+1][j-1] + 2;

                if( dp[i][j] > len ){
                    len = dp[i][j];
                    si = i; ei = j;
                }
            }
        }
        return str.substring( si, ei + 1);
    }

    public static int longestPalindromeSubseq( String str, int i, int j, int[][] dp){
        if( i > j || i == j )
            return dp[i][j] = ( i == j ) ? 1 : 0;

        if( dp[i][j] != 0)
            return dp[i][j];

        if( str.charAt(i) == str.charAt(j) )
            dp[i][j] = longestPalindromeSubseq( str, i + 1, j - 1, dp) + 2;
        else 
            dp[i][j] = Math.max( longestPalindromeSubseq( str, i + 1, j, dp), longestPalindromeSubseq( str, i, j - 1, dp) );

        return dp[i][j];
    }

    public static int longestPalindromeSubseqDP( String str, int I, int J, int[][] dp){
        int n = str.length();
        
        for( int gap = 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; i++, j++){
                if( i > j || i == j ){
                    dp[i][j] = ( i == j ) ? 1 : 0;
                    continue;
                }
    
            if( str.charAt(i) == str.charAt(j) )
                dp[i][j] = dp[i+1][j-1] + 2;
            else 
                dp[i][j] = Math.max( dp[i+1][j], dp[i][j-1] );
            }
        }
        return dp[I][J];
    }

    public static String longestPalindromeSubseq( String str, int I, int J, int[][] dp, String[][] sDp){
        int n = str.length();
        
        for( int gap = 0; gap < n; gap++){
            for( int i = 0, j = gap; j < n; i++, j++){
                if( i > j || i == j ){
                    dp[i][j] = ( i == j ) ? 1 : 0;
                    sDp[i][j] = str.charAt(i) + "";
                    continue;
                }
    
            if( str.charAt(i) == str.charAt(j) ){
                dp[i][j] = dp[i+1][j-1] + 2;
                sDp[i][j] = str.charAt(i) + sDp[i+1][j-1] + str.charAt(i);
            }
            else{ 
                if( dp[i+1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i+1][j];
                    sDp[i][j] = sDp[i+1][j];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                    sDp[i][j] = sDp[i][j-1];
                }
            }
            }
        }
        return sDp[I][J];    
    }

         // ls = left palindrome string,rs = right palindrome string
         public static void generateString(int[][] dp,String s,int i,int j,LinkedList<Character> ls,LinkedList<Character> rs){
            if(i > j || i == j){
                if(i==j){
                    ls.addLast(s.charAt(i));
                }
    
                System.out.print(ls);
                System.out.print(rs);
                System.out.println();
                
                if(i==j){
                    ls.removeLast();
                }
     
                return;
            }
    
            if(s.charAt(i) == s.charAt(j)){            
                ls.addLast(s.charAt(i));
                rs.addFirst(s.charAt(i));
    
                generateString(dp,s,i+1,j-1,ls,rs);
    
                ls.removeLast();
                rs.removeFirst();
            } 
            else{
    
                if(dp[i+1][j] > dp[i][j-1]) generateString(dp,s,i+1,j,ls,rs);
                else if(dp[i+1][j] < dp[i][j-1]) generateString(dp,s,i,j-1,ls,rs);
                else{
                    generateString(dp,s,i,j-1,ls,rs);
                    generateString(dp,s,i+1,j,ls,rs);
                }
            }
        }

    public static void generateString( String str, int i, int j, int[][] dp, String ls, String rs){
        if( i > j || i == j){
            if( i == j ){
                ls += str.charAt(i);
            }
            System.out.println( ls + rs );
            return;
        }

        if( str.charAt(i) == str.charAt(j)){
            generateString( str, i + 1, j - 1, dp, ls + str.charAt(i), str.charAt(j) + rs);
        }else{
            if( dp[i+1][j] > dp[i][j-1]){
                generateString( str, i + 1, j, dp, ls, rs);
            }
            else if( dp[i+1][j] < dp[i][j-1])
                generateString( str, i, j - 1, dp, ls, rs);
            }
    }

    public static void generateString( String str ){
        int n = str.length();
        generateString( str, 0, n - 1, new int[n][n], "", "");
    }

    public static void longestPalindromeSubseq( String str ){
        // int n = str.length();
        // int[][] dp = new int[n][n];
        // String[][] sDp = new String[n][n];
        // for( String[] s : sDp ){
        //     Arrays.fill( s, "");
        // }
        // int ans = longestPalindromeSubseq( str, 0, n - 1, dp);
        // int ans = longestPalindromeSubseqDP( str, 0, n - 1, dp);
        // String s = longestPalindromeSubseq( str, 0, n - 1, dp, sDp);
        
        // System.out.println( s );
        generateString( str );
    }

    public static void main( String[] args){
        String str = "afgbcbddbcbgf";
        // boolean[][] dp = new boolean[str.length()][str.length()];
        // palindromicSubString( str, dp);
        // System.out.println( countPalindromic( str, dp) );
        int[][] dp = new int[str.length()][str.length()];
        // System.out.println( longestPalindrome( str, dp) );

        // longestPalindromeSubseq(str);
        int n = str.length();
        generateString(dp, str, 0, n - 1, new LinkedList<>(), new LinkedList<>());

    }
}