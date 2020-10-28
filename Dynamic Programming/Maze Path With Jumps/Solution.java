import java.util.Arrays;
public class Solution{
    static int[][] dir = { {0,1}, {1,1}, {1,0} };
    public static int getMazeJumps( int sr, int sc, int dr, int dc ){
        if( sr == dr - 1 && sc == dc - 1 ){
            return 1;
        }
        int count = 0;
        for( int jump = 1; jump < Math.max( dr, dc ); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];
                
                if( x >= 0 && y >= 0 && x < dr && y < dc ){
                    count += getMazeJumps( x, y, dr, dc );
                }
            }
        }
        return count;
    }

    public static int getMazeJumpsMem( int sr, int sc, int dr, int dc, int[][] dp ){
        if( sr == dr - 1 && sc == dc - 1 ){
            return dp[sr][sc] = 1;
        }
        if( dp[sr][sc] != -1 ) return dp[sr][sc];
        int count = 0;
        for( int jump = 1; jump < Math.max( dr, dc ); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];
                
                if( x >= 0 && y >= 0 && x < dr && y < dc ){
                    count += getMazeJumpsMem( x, y, dr, dc, dp );
                }
            }
        }
        return dp[sr][sc] = count;
    }

    public static int getMazeJumpsDP( int SR, int SC, int dr, int dc, int[][] dp ){
        for( int sr = dr - 1; sr >= 0; sr-- ){
            for( int sc = dc - 1; sc >= 0; sc-- ){
                if( sr == dr - 1 && sc == dc - 1 ){
                    dp[sr][sc] = 1;
                    continue;
                }
                
                int count = 0;
                for( int jump = 1; jump < Math.max( dr, dc ); jump++ ){
                    for( int d = 0; d < dir.length; d++ ){
                        int x = sr + jump * dir[d][0];
                        int y = sc + jump * dir[d][1];
                        
                        if( x >= 0 && y >= 0 && x < dr && y < dc ){
                            count += dp[x][y]; //getMazeJumpsMem( x, y, dr, dc, dp );
                        }
                    }
                }
                dp[sr][sc] = count; 
            }
        }
        return dp[SR][SC];
    }

    public static void Maze(){
        int n = 4;
        int m = 4;
        // System.out.println( getMazeJumps( 0, 0, n, m ) );
        int[][] dp = new int[n][m];
        for( int[] a : dp ){
            Arrays.fill( a, -1);
        }
        // System.out.println( getMazeJumpsMem( 0, 0, n, m, dp ) );
        // for( int[] a : dp ){
        //     for( int ele : a ){
        //         System.out.print( ele + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println( getMazeJumpsDP( 0, 0, n, m, dp) );
    }
    public static void main(String[] args) {
        Maze();
    }
}