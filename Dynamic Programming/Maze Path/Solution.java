import java.util.Arrays;
public class Solution{
    static int[][] dir = {  { 0 , 1 }, { 1, 1 }, { 1, 0 } };
    public static int getMazeWaysRecursive( int sr, int sc, int er, int ec ){
        if( sr == er - 1 && sc == ec - 1 ){
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && y >= 0 && x < er && y < ec ){
                count += getMazeWaysRecursive( x, y, er, ec );
            }
        }

        return count;
    }

    public static int getMazeWaysMem( int sr, int sc, int er, int ec, int[][] dp ){
        if( sr == er - 1 && sc == ec - 1 ){
            return dp[sr][sc] = 1;
        }

        if( dp[sr][sc] != -1 ){
            return dp[sr][sc];
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && y >= 0 && x < er && y < ec ){
                count += getMazeWaysMem( x, y, er, ec, dp );
            }
        }

        return dp[sr][sc] = count;
    }

    public static int getMazeWaysDp( int SR, int SC, int er, int ec, int[][] dp ){
        for( int sr = er - 1; sr >= 0; sr-- ){
            for( int sc = ec - 1; sc >= 0; sc-- ){
            if( sr == er - 1 && sc == ec - 1 ){
                dp[sr][sc] = 1;
                continue;
            }
    
            int count = 0;
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + dir[d][0];
                int y = sc + dir[d][1];
    
                if( x >= 0 && y >= 0 && x < er && y < ec ){
                    count += dp[x][y]; // getMazeWaysMem( x, y, er, ec, dp );
                }
            }
            
            dp[sr][sc] = count;
        }
    }

        return dp[SR][SC];
    }

    

    public static void maze(){
        int n = 4;
        int m = 4;
        // System.out.println( getMazeWaysRecursive( 0, 0, n, m ) );
        int[][] dp = new int[n][m];
        for( int[] a : dp ){
            Arrays.fill( a, -1 );
        }
        // System.out.println( getMazeWaysMem( 0, 0, n, m, dp ) );
        // for( int[] a : dp ){
            //     for( int e : a ){
        //         System.out.print( e + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println( getMazeWaysDp( 0, 0, n, m, dp ) );
    }
    public static void main( String[] args ){
        maze();
    }   
}