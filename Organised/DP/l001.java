public class l001{
    
    public static void print( int[] arr ){
        for( int ele : arr ) System.out.print( ele + " ");
        System.out.println();
    }
    
    public static void print2D( int[][] arr ){
        for( int[] a : arr ) print( a );
    }

    // Fibonacci 

    public static int fibR( int n ){
        if( n <= 1 ) return n;

        return fibR( n - 1 ) + fibR( n - 2 );
    }

    public static int fibM( int n, int[] dp ){
        if( n <= 1 ) return dp[ n ] =  n;

        if( dp[ n ] != 0 ) return dp[ n ];

        int a = fibM( n - 1, dp );
        int b = fibM( n - 2, dp );

        return dp[n] = a + b;
    }

    public static int fibDP( int N, int[] dp ){
        
        for( int n = 0; n <= N; n++ ){
            if( n <= 1 ) {
                dp[ n ] =  n;
                continue;
            }
    
            int a = dp[ n - 1 ]; //fibM( n - 1, dp );
            int b = dp[ n - 2 ]; //fibM( n - 2, dp );
    
            dp[n] = a + b;
        }
        return dp[ N ];
    }

    public static int fibOpti( int N ){
        int a = 0, b = 1;
        for( int n = 2; n <= N; n++ ){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void fib(){
        int n = 11;
        int[] dp = new int[ n + 1 ];
        // System.out.println( fibR( n ) );
        // System.out.println( fibM( n, dp ) );
        // print( dp );
        // System.out.println( fibDP( n, dp ) );
        System.out.println( fibOpti( n ) );
    }

    // -------------------- Mazepath ----------------------
    static int[][] dir = { { 0, 1}, { 1, 1}, { 1, 0} };
    public static int mazePath( int sr, int sc, int er, int ec){
        if( sr == er - 1 && sc == ec - 1 ){
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            
            if( x >= 0 && x < er && y >= 0 && y < ec ){
                count += mazePath( x, y, er, ec);
            }
        }
        return count;
    }

    public static int mazePathM( int sr, int sc, int er, int ec, int[][] dp ){
        if( sr == er - 1 && sc == ec - 1 ){
            return dp[sr][sc] = 1;
        }

        if( dp[sr][sc] != 0 ) 
            return dp[sr][sc];

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec ){
                count += mazePathM( x, y, er, ec, dp);
            }
        }
        return dp[sr][sc] = count;     
    }

    public static int mazePathDP( int SR, int SC, int er, int ec, int[][] dp ){
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
        
                    if( x >= 0 && x < er && y >= 0 && y < ec ){
                        count += dp[ x ][ y ];  //mazePathM( x, y, er, ec, dp);
                    }
                }
                dp[sr][sc] = count;     
            }
        }
        return dp[ SR ][ SC ];
    }

    public static int mazePathJ( int sr, int sc, int er, int ec ){
        if( sr == er - 1 && sc == ec - 1 ){
            return 1;
        }

        int count = 0;
        for( int jump = 1; jump < Math.max( er, ec); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];

                if( x >= 0 && x < er && y >= 0 && y < ec ){
                    count += mazePathJ( x, y, er, ec );
                }
            }
        }
        return count;
    }

    public static int mazePathJ( int sr, int sc, int er, int ec, int[][] dp){
        if( sr == er - 1 && sc == ec - 1 ){
            return dp[sr][sc] =  1;
        }

        if( dp[sr][sc] != 0 )
            return dp[sr][sc];

        int count = 0;
        for( int jump = 1; jump < Math.max( er, ec); jump++ ){
            for( int d = 0; d < dir.length; d++ ){
                int x = sr + jump * dir[d][0];
                int y = sc + jump * dir[d][1];

                if( x >= 0 && x < er && y >= 0 && y < ec ){
                    count += mazePathJ( x, y, er, ec, dp );
                }
            }
        }
        return dp[sr][sc] = count;   
    }

    public static int mazePathJDP( int SR, int SC, int er, int ec, int[][] dp){
        for( int sr = er - 1; sr >= 0; sr-- ){
            for( int sc = ec - 1; sc >= 0; sc-- ){
                if( sr == er - 1 && sc == ec - 1 ){
                    dp[sr][sc] =  1;
                    continue;
                }
        
                int count = 0;
                for( int jump = 1; jump < Math.max( er, ec); jump++ ){
                    for( int d = 0; d < dir.length; d++ ){
                        int x = sr + jump * dir[d][0];
                        int y = sc + jump * dir[d][1];
        
                        if( x >= 0 && x < er && y >= 0 && y < ec ){
                            count += dp[x][y];  //mazePathJ( x, y, er, ec, dp );
                        }
                    }
                }
                dp[sr][sc] = count;  
            }
        }

        return dp[SR][SC];
    }

    public static void mazePath(){
        int n = 5; 
        int m = 5;
        int[][] dp = new int[ n ][ m ];
        // System.out.println( mazePath( 0, 0, n, m) );
        // System.out.println( mazePathM( 0, 0, n, m, dp) );
        // print2D( dp );
        // System.out.println( mazePathDP( 0, 0, n, m, dp) );

        // System.out.println( mazePathJ( 0, 0, n, m) );
        // System.out.println( mazePathJ( 0, 0, n, m, dp) );
        // print2D( dp );
        System.out.println( mazePathJDP( 0, 0, n, m, dp) );
    }

    public static void twoPointer(){
        // fib();
        mazePath();
    }
    public static void solve(){
        twoPointer();
    }
    public static void main(String[] args) {
        solve();
    }
}