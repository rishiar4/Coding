import java.util.ArrayList;
import java.util.Arrays;

public class l002{
    // static int[][] dir = { { 0, 1 }, { 1, 0 } };
    // static String[] dirS = { "H", "V" };

    // static int[][] dir = { { 0, 1}, { 1, 1}, { 1, 0} };
    // static String[] dirS = { "H", "D", "V" };

    // static int[][] dir = { { 0, 1}, { 1, 0}, { 0, -1}, { -1, 0} };
    // static String[] dirS = { "R", "D", "L", "U" };

    // static int[][] dir = { { -1, 0}, { -1, 1}, { 0, 1}, { 1, 1}, { 1, 0}, { 1, -1}, { 0, -1}, { -1, -1} };
    static String[] dirS = { "N", "NE", "E", "SE", "S", "SW", "W", "NW" };

    public static int mazePath( int sr, int sc, int er, int ec, String ans ){
        if( sr == er - 1 && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec ){
                count += mazePath( x, y, er, ec, ans + dirS[d] );
            }
        }
        return count;
    }

    public static int mazePathJump( int sr, int sc, int er, int ec, String ans ){
        if( sr == er - 1 && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }

        int count = 0;
        for( int jump = 1; jump < Math.max( er, ec ); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];
                if( x >= 0 && x < er && y >= 0 && y < ec )
                    count += mazePathJump( x, y, er, ec, ans + dirS[d] + jump + " "  );
            }
        }

        return count;
    }
    
    public static ArrayList<String> mazePath( int sr, int sc, int er, int ec ){
        if( sr == er - 1 && sc == ec - 1 ){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec ){
                ArrayList<String> recAns = mazePath( x, y, er, ec );
                for( String s : recAns ){
                    myAns.add( dirS[d] + s );
                }
            }
        }

        return myAns;

    }

    public static int mazePathD( int sr, int sc, int er, int ec, String ans ){
        if( sr == er - 1 && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            if( x >= 0 && x < er && y >= 0 && y < ec ){
                count += mazePathD( x, y, er, ec, ans + dirS[d] );
            }
        }
        return count;
    }

    public static int mazePathDJump( int sr, int sc, int er, int ec, String ans ){
        if( sr == er - 1 && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }

        int count = 0;
        for( int jump = 1; jump < Math.max( er, ec ); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];
                if( x >= 0 && x < er && y >= 0 && y < ec ){
                    count += mazePathDJump( x, y, er, ec, ans + dirS[d] + jump + " ");
                }
            }
        }

        return count;
    }

    public static int mazePathFour( int sr, int sc, int er, int ec, boolean[][] vis, String ans ){
        if( sr == er - 1  && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }

        vis[sr][sc] = true;
        
        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            if( x >= 0 && x < er && y >= 0 && y < ec && !vis[x][y] ){
                count += mazePathFour( x, y, er, ec, vis, ans + dirS[d] );
            }
        }

        vis[sr][sc] = false;

        return count;
    }

    public static int mazePathFourJump( int sr, int sc, int er, int ec, boolean[][] vis, String ans ){
        if( sr == er - 1 && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }

        vis[sr][sc] = true;
        int count = 0;

        for( int jump = 1; jump < Math.max( er, ec ); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];
                if( x >= 0 && x < er && y >= 0 && y < ec && !vis[x][y] ){
                    count += mazePathFourJump( x, y, er, ec, vis, ans + dirS[d] + jump + " " );
                }
            }
        }

        vis[sr][sc] = false;
        return count;
    }

    public static int mazePathEight( int sr, int sc, int er, int ec, boolean[][] vis, String ans ){
        if( sr == er - 1 && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }

        vis[sr][sc] = true;
        int count = 0;

        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            if( x >= 0 && x < er && y >= 0 && y < ec && !vis[x][y] ){
                count += mazePathEight( x, y, er, ec, vis, ans + dirS[d] );
            }
        }

        vis[sr][sc] = false;
        return count;
    }

    public static int mazePathEightJump( int sr, int sc, int er, int ec, boolean[][] vis, String ans ){
        if( sr == er - 1 && sc == ec - 1 ){
            System.out.println( ans );
            return 1;
        }
        vis[sr][sc] = true;
        int count = 0;

        for( int jump = 1; jump < Math.max( er, ec ); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];
                if( x >= 0 && x < er && y >= 0 && y < ec && !vis[x][y] ){
                    count += mazePathEightJump( x, y, er, ec, vis, ans + dirS[d] + jump + " - ");
                }
            }
        }

        vis[sr][sc] = false;
        return count;
    }


    public static void maze(){
        // System.out.println( mazePath( 0, 0, 3, 3 ) );
        // mazePath( 0, 0, 3, 3, "");
        // mazePathJump( 0, 0, 3, 3, "");

        // mazePathD( 0, 0, 3, 3, "");
        // mazePathDJump( 0, 0, 3, 3, "");

        // mazePathFour( 0, 0, 3, 3, new boolean[3][3], "");
        // mazePathFourJump( 0, 0, 3, 3, new boolean[3][3], "");

        // mazePathEight( 0, 0, 3, 3, new boolean[3][3], "" );
        // mazePathEightJump( 0, 0, 3, 3, new boolean[3][3], "");

    }

    static int[][] dir = { { 2, 1}, { 1, 2}, { -1, 2}, { -2, 1}, { -2, -1}, { -1,  -2}, { 1, -2}, { 2, -1} };

    public static boolean knightTour( int[][] board, int sr, int sc, int steps ){
        
        if( steps == 64 ){
            board[sr][sc] = steps;
            return true;
        }
        
        board[sr][sc] = steps;
        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == -1 ){
                boolean res = knightTour( board, x, y, steps + 1 );
                if( res ) return true;
            }
        }

        board[sr][sc] = -1;
        return false;
    }

    public static void print( int[][] board ){
        for( int[] a : board ){
            for( int ele : a ){
                System.out.print( ele + " ");
            }
            System.out.println();
        }
    }
    public static void knightTour(){
        int[][] board = new int[8][8];
        for( int[] a : board ){
            Arrays.fill( a, -1 );
        }

        knightTour( board, 0, 0, 1 );

        print( board );
    }



    public static void main( String[] args ){
        // maze();
        knightTour();
    }
}