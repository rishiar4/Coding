import java.util.Arrays;
import java.util.LinkedList;
public class Solution{
    public static int getBoardWays( int sp, int ep ){
        if( sp == ep ){
            return 1;
        }

        int count = 0;
        for( int i = 1; i <= 6 && sp + i <= ep ; i++ ){
            count+= getBoardWays( sp + i, ep );
        }

        return count;
    }

    public static int getBoardWaysMem( int sp, int ep, int[] dp ){
        if( sp == ep ){
            return dp[sp] = 1;
        }

        if(dp[sp] != -1 ) 
            return dp[sp];

        int count = 0;
        for( int i = 1; i <= 6 && sp + i <= ep ; i++ ){
            count+= getBoardWaysMem( sp + i, ep, dp );
        }

        return dp[sp] = count;   
    }

    public static int getBoardWaysDP( int sp, int ep, int[] dp){
        for( sp = ep; sp >= 0; sp-- ){
            if( sp == ep ){
                dp[sp] = 1;
                continue;
            }
        
            int count = 0;
            for( int i = 1; i <= 6 && sp + i <= ep ; i++ ){
                count+= dp[ sp + i ]; // getBoardWaysMem( sp + i, ep, dp );
            }
    
            dp[sp] = count;  
        }
        return dp[0];
    }

    public static int getBoardOpti( int n ){
        LinkedList<Integer> ll = new LinkedList<>();

        for( int sp = n; sp >= 0; sp-- ){
            if( ll.size() <= 1 )
                ll.addFirst(1);
            else if( ll.size() <= 6 )
                ll.addFirst( 2 * ll.getFirst() );
            else
                ll.addFirst( 2 * ll.getFirst() - ll.removeLast() );
        }

        return ll.getFirst();
    }

    public static void board(){
        int n = 10;
        // int ans = getBoardWays( 0, n );
        int[] dp = new int[ n + 1 ];
        Arrays.fill(dp,-1);

        // int ans = getBoardWaysMem( 0, n, dp);
        // for( int ele : dp ){
        //     System.out.print(ele + " ");
        // }

        // int ans = getBoardWaysDP( 0, n, dp);
        int ans = getBoardOpti( n );
        System.out.println( ans );
    }
    public static void main(String[] args) {
        board();
    }
}