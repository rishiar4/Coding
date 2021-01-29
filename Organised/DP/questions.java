public class questions{
    // LeetCode 62
    static int[][] dir = { { 1, 0}, { 0, 1} };

    public int uniquePaths( int sr, int sc, int er, int ec){
        if( sr == er - 1 && sc == ec - 1){
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec){
                count += uniquePaths( x, y, er, ec);
            }
        }
        return count;
    }

    public int uniquePathsM( int sr, int sc, int er, int ec, int[][] dp){
        if( sr == er - 1 && sc == ec - 1){
            return dp[sr][sc] = 1;
        }

        if( dp[sr][sc] != 0 )
            return dp[sr][sc];
        
        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec){
                count += uniquePathsM( x, y, er, ec, dp);
            }
        }
        return dp[sr][sc] = count;
    }

    public int uniquePathsDP( int SR, int SC, int er, int ec, int[][] dp){
        for( int sr = er - 1; sr >= 0; sr-- ){
            for( int sc = ec - 1; sc >= 0; sc-- ){
                if( sr == er - 1 && sc == ec - 1){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for( int d = 0; d < dir.length; d++){
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
        
                    if( x >= 0 && x < er && y >= 0 && y < ec){
                        count += dp[x][y]; // uniquePathsM( x, y, er, ec, dp);
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }

    public int uniquePaths(int m, int n) {
        // return uniquePaths( 0, 0, m, n);
        int[][] dp = new int[m][n];
        // return uniquePathsM( 0, 0, m, n, dp);
        return uniquePathsDP( 0, 0, m, n, dp);
    }
    // LeetCode 63
    static int[][] dir = { { 1, 0}, { 0, 1} };

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int sr, int sc, int er, int ec){
        if( sr == er - 1 && sc == ec - 1){
            return 1;
        }

        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec && obstacleGrid[x][y] == 0 ){
                count += uniquePathsWithObstacles(obstacleGrid, x, y, er, ec);
            }
        }
        return count;
    }

    public int uniquePathsWithObstaclesMem( int[][] obstacleGrid, int sr, int sc, int er, int ec, int[][] dp){
        if( sr == er - 1 && sc == ec - 1){
            return dp[sr][sc] = 1;
        }

        if( dp[sr][sc] != 0 )
            return dp[sr][sc];

        int count = 0;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if( x >= 0 && x < er && y >= 0 && y < ec && obstacleGrid[x][y] == 0){
                count += uniquePathsWithObstaclesMem( obstacleGrid, x, y, er, ec, dp);
            }
        }
        
        return dp[sr][sc] = count;
    }

    public int uniquePathsWithObstaclesDP( int[][] obstacleGrid, int SR, int SC, int er, int ec, int[][] dp ){
        for( int sr = er - 1; sr >= 0; sr-- ){
            for( int sc = ec - 1; sc >= 0; sc-- ){
                if( sr == er - 1 && sc == ec - 1){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for( int d = 0; d < dir.length; d++ ){
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
        
                    if( x >= 0 && x < er && y >= 0 && y < ec && obstacleGrid[x][y] == 0){
                        count += dp[x][y]; //uniquePathsWithObstaclesMem( obstacleGrid, x, y, er, ec, dp);
                    }
                }
                
                dp[sr][sc] = count;   
            }
        }

        return dp[SR][SC];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if( obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if( obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1 )
            return 0;

        // return uniquePathsWithObstacles( obstacleGrid, 0, 0, n, m);
        int[][] dp = new int[n][m];
        // int ans = uniquePathsWithObstaclesMem( obstacleGrid, 0, 0, n, m, dp );

        // for( int[] a : dp ){
        //     for( int ele : a ){
        //         System.out.print( ele + " " );
        //     }
        //     System.out.println();
        // }
        int ans = uniquePathsWithObstaclesDP( obstacleGrid, 0, 0, n, m, dp );
        return ans;
    }

    // LeetCode 64
    static int[][] dir = { { 1, 0 }, { 0, 1} };

    public int minPathSum( int[][] grid, int sr, int sc, int er, int ec ){
        if( sr == er - 1 && sc == ec - 1){
            return grid[sr][sc];
        }

        int minCost = (int)1e8;
        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            
            if( x >= 0 && x < er && y >= 0 && y < ec )
                minCost = Math.min( minCost, minPathSum( grid, x, y, er, ec ) );
        }

        return minCost + grid[sr][sc];
    }

    public int minPathSum( int[][] grid, int sr, int sc, int er, int ec, int[][] dp ){
        if( sr == er - 1 && sc == ec - 1){
            return dp[sr][sc] = grid[sr][sc];
        }
        
        if( dp[sr][sc] != (int)1e8)
            return dp[sr][sc];

        for( int d = 0; d < dir.length; d++ ){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            
            if( x >= 0 && x < er && y >= 0 && y < ec )
                dp[sr][sc] = Math.min( dp[sr][sc], minPathSum( grid, x, y, er, ec, dp ) );
        }

        return dp[sr][sc] += grid[sr][sc];
    }

    public int minPathSumDP( int[][] grid, int SR, int SC, int er, int ec, int[][] dp){
        for( int sr = er - 1; sr >= 0; sr--){
            for( int sc = ec - 1; sc >= 0; sc--){
                if( sr == er - 1 && sc == ec - 1){
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }
        
                for( int d = 0; d < dir.length; d++ ){
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
                    
                    if( x >= 0 && x < er && y >= 0 && y < ec )
                        dp[sr][sc] = Math.min( dp[sr][sc], dp[x][y] ); //minPathSum( grid, x, y, er, ec, dp ) );
                }
        
                dp[sr][sc] += grid[sr][sc];
            }
        }

        return dp[SR][SC];
    }

    public int minPathSum(int[][] grid) {
        if( grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int n = grid.length;
        int m = grid[0].length;

        // return minPathSum( grid, 0, 0, n - 1, m - 1);
        int[][] dp = new int[n][m];
        for( int[] a : dp ){
            Arrays.fill( a, (int)1e8 );
        }

        // int ans = minPathSum( grid, 0, 0, n , m , dp);
        int ans = minPathSumDP( grid, 0, 0, n, m, dp);
        for( int[] a : dp ){
            for( int ele : a ){
                System.out.print( ele + " ");
            }
            System.out.println();
        }
        return ans;
    }

    // 70. Climbing Stairs
    public int climbStairsR( int n){
        if( n <= 1 )
            return 1;

        int val = climbStairsR( n - 1 ) + climbStairsR( n - 2 );

        return val;
    }

    public int climbStairs( int n, int[] dp){
        if( n <= 1 )
            return dp[n] = 1;

        if( dp[n] != 0)
            return dp[n];

        int val = climbStairs( n - 1, dp) + climbStairs( n - 2,dp );

        return dp[n] = val;    
    }

    public int climbStairsDP( int N, int[] dp){
        for( int n = 0; n <= N; n++){
        if( n <= 1 ){
            dp[n] = 1;
            continue;
        }
        int val = climbStairs( n - 1, dp) + climbStairs( n - 2,dp );

        dp[n] = val;  
        }
        return dp[N];
    }

    public int climbStairs(int n) {
        // int ans = climbStairsR( n );
        int[] dp = new int[ n + 1 ];
        // int ans = climbStairs( n, dp);
        int ans = climbStairsDP( n, dp);
        return ans;
    }

    // 746. Min Cost Climbing Stairs
    public int minCostClimbingStairs( int n, int[] cost){
        if( n <= 1 )
            return cost[n];
        
        int val = Math.min( minCostClimbingStairs( n - 1, cost), minCostClimbingStairs( n - 2, cost) );

        return val + ( n < cost.length ? cost[n] : 0 );
    }

    public int minCostClimbingStairs( int n, int[] cost, int[] dp){
        if( n <= 1)
            return dp[n] = cost[n];

        if( dp[n] != 0)
            return dp[n];

        int val = Math.min( minCostClimbingStairs( n - 1, cost, dp), minCostClimbingStairs( n - 2, cost, dp) );

        return dp[n] = val + ( n < cost.length ? cost[n] : 0);
    }

    public int minCostClimbingStairsDP( int N, int[] cost, int[] dp){
        for( int n = 0; n <= N; n++ ){
        if( n <= 1){
            dp[n] = cost[n];
            continue;
        }
        int val = Math.min( dp[n-1], dp[n-2] );

        dp[n] = val + ( n < cost.length ? cost[n] : 0); 
        }
        return dp[N];
    }

    public int minCostClimbingStairs(int[] cost) {
        if( cost.length == 0 )
            return 0;

        int n = cost.length;
        // int ans = minCostClimbingStairs( n, cost );
        int[] dp = new int[ n + 1 ];
        // int ans = minCostClimbingStairs( n, cost, dp);
        int ans = minCostClimbingStairsDP( n, cost, dp);
        return ans;
    }

    // 91. Decode Ways
    public int numDecodings( String s, int idx){
        if( idx == s.length() ){
            return 1;
        }

        int count = 0;

        if( s.charAt(idx) == '0'){
            return 0;
        }

        count += numDecodings( s, idx + 1);

        if( idx < s.length() - 1){
            int num1 = s.charAt( idx ) - '0';
            int num2 = s.charAt( idx + 1 ) - '0';
            
            int num = num1 * 10 + num2;
            if( num <= 26){
                count += numDecodings( s, idx + 2);
            }
        }

        return count;
    }

    public int numDecodings( String s, int idx, int[] dp){
        if( idx == s.length() ){
            return dp[idx] = 1;
        }

        if( dp[idx] != -1){
            return dp[idx];
        }
        
        int count = 0;

        if( s.charAt(idx) == '0'){
            return dp[idx] = 0;
        }

        count += numDecodings( s, idx + 1, dp);

        if( idx < s.length() - 1){
            int num1 = s.charAt( idx ) - '0';
            int num2 = s.charAt( idx + 1 ) - '0';
            
            int num = num1 * 10 + num2;
            if( num <= 26){
                count += numDecodings( s, idx + 2, dp);
            }
        }

        return dp[idx] = count;   
    }

    public int numDecodingsDP( String s, int IDX, int[] dp){
        for( int idx = s.length(); idx >= 0; idx--){
            if( idx == s.length() ){
                dp[idx] = 1;
                continue;
            }
            
            int count = 0;
    
            if( s.charAt(idx) == '0'){
                dp[idx] = 0;
                continue;
            }
    
            count += dp[idx+1];//numDecodings( s, idx + 1, dp);
    
            if( idx < s.length() - 1){
                int num1 = s.charAt( idx ) - '0';
                int num2 = s.charAt( idx + 1 ) - '0';
                
                int num = num1 * 10 + num2;
                if( num <= 26){
                    count += dp[idx+2]; //numDecodings( s, idx + 2, dp);
                }
            }
    
            dp[idx] = count;  
        }
        return dp[IDX];
    }

    public int numDecodingsOpti( String s, int idx){

        int a = 1;
        int b = 0;

        for (int idx = s.length() - 1; idx >= 0; idx--)
        {
            int sum = 0;
            char ch = s[idx];
            if (ch == '0')
                sum = 0;
            else
            {
                sum = a;
                if (idx < s.length() - 1)
                {
                    int num = (s[idx] - '0') * 10 + (s[idx + 1] - '0');
                    if (num <= 26)
                        sum += b;
                }
            }
    
            b = a;
            a = sum;
        }
    
        return a; 
    }

    public int numDecodings(String s) {
        int n = s.length();
        if( n == 0 )
            return 0;
        
        // int ans = numDecodings( s, 0);
        int[] dp = new int[ n + 1 ];
        Arrays.fill( dp, -1);
        // int ans = numDecodings( s, 0, dp);
        // int ans = numDecodingsDP( s, 0, dp);
        int ans = numDecodingsOpti( s, 0);
        return ans;
    }

    // 639. Decode Ways II
    static int mod = (int)1e9 + 7;

    public long numDecodings( String s, int idx){
        if( idx == s.length()){
            return 1;
        }

        if( s.charAt(idx) == 0){
            return 0;
        }

        if( dp[idx] != -1)
            return dp[idx];
        long count = 0;

        if (s.charAt(idx) == '*'){
            count = (count + 9 * numDecodings(s, idx + 1, dp) % mod) % mod;
            if (idx < s.length() - 1 && s.charAt( idx + 1 ) >= '0' && s.charAt( idx + 1 ) <= '6')
                count = (count + 2 * numDecodings(s, idx + 2, dp) % mod) % mod;
            else if (idx < s.length() - 1 && s.charAt( idx + 1 ) >= '7')
                count = (count + numDecodings(s, idx + 2, dp) % mod) % mod;
            else if (idx < s.length() - 1 && s.charAt( idx + 1 ) == '*')
                count = (count + 15 * numDecodings(s, idx + 2, dp) % mod) % mod;
        }else{
            count = (count + numDecodings(s, idx + 1, dp) % mod) % mod;
            if (idx < s.length() - 1 && s.charAt( idx + 1 ) == '*'){
                if (ch == '1')
                    count = (count + 9 * numDecodings(s, idx + 2, dp) % mod) % mod;
                else if (ch == '2')
                    count = (count + 6 * numDecodings(s, idx + 2, dp) % mod) % mod;
            }else if (idx < s.length() - 1){
                int num = (ch - '0') * 10 + (s.charAt( idx + 1 ) - '0');
                if (num <= 26)
                    count = (count + numDecodings(s, idx + 2, dp) % mod) % mod;
            }
        }
        return dp[idx] = count;
    }

    public int numDecodings(String s) {
        int n = s.length();
        if( n == 0 )
            return 0;
        int[] dp = new int[ n + 1];
        Arrays.fill( dp, -1);
        return (int)numDecodings( s, 0, dp);
    }


}