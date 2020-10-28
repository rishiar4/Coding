import java.util.Arrays;
public class Solution{
    public static int goldMineRecursive( int r, int c, int n, int m, int[][] gold, int[][] dir ){
        if( c == m - 1 ){
            return gold[r][c];
        }
        int maxValue = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            if( x >= 0 && y >= 0 && x < n && y < n )
                maxValue = Math.max( maxValue, goldMineRecursive( x, y, n, m, gold, dir ) + gold[r][c] );
        }

        return maxValue;
    }

    public static int goldMineMem( int r, int c, int n, int m, int[][] gold, int[][] dir, int[][] dp ){
        if( c == m - 1 ){
            return dp[r][c] = gold[r][c];
        }
        
        if( dp[r][c] != -1 ) return dp[r][c];

        int maxValue = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            if( x >= 0 && y >= 0 && x < n && y < n )
                maxValue = Math.max( maxValue, goldMineMem( x, y, n, m, gold, dir, dp ) + gold[r][c] );
        }

        return dp[r][c] =  maxValue;
    }

    public static int goldMineDP( int n, int m, int[][] gold, int[][] dir, int[][] dp ){
        for( int c = m - 1; c >= 0; c-- ){
            for( int r = n - 1; r >= 0; r-- ){
                if( c == m - 1 ){
                    dp[r][c] = gold[r][c];
                    continue;
                }
                
        
                int maxValue = 0;
                for( int d = 0; d < dir.length; d++ ){
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];
                    if( x >= 0 && y >= 0 && x < n && y < n )
                        maxValue = Math.max( maxValue, dp[x][y] + gold[r][c] );
                }
        
                dp[r][c] =  maxValue;            
            }
        }
        int max = 0;
        for( int r = 0; r < n; r++ ){
            max = Math.max( max, dp[r][0]);
        }
        return max;
    }

    public static void goldMine(){
        int[][] gold = { {1, 3, 3}, {2, 1, 4}, {0, 6, 4} };
        int[][] dir = { {-1,1}, {0,1}, {1,1} };

        int n = gold.length;
        int m = gold[0].length;
        int[][] dp = new int[n][m];
        
        // int maxValue = 0;
        // for( int r = 0; r < n; r++ ){
        //     maxValue = Math.max( maxValue, goldMineRecursive( r, 0, n, m, gold, dir ) );
        // }

        for( int[] a : dp ){
            Arrays.fill(a, -1);
        }

        // int maxValue = 0;
        // for( int r = 0; r < n; r++ ){
        //     maxValue = Math.max( maxValue, goldMineMem( r, 0, n, m, gold, dir, dp ) );
        // }

        // System.out.println( maxValue );

        System.out.println( goldMineDP( n, m, gold, dir, dp) );

    }
    public static void main(String[] args) {
        goldMine();
    }
}