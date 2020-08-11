import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in );
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ranks[] = {1, 56,3, 69, 85, 96};

        for( int val: ranks )
        {
            pq.add(val);
        }
        
        while( pq.size() > 0 )
        {
            System.out.println( pq.peek() );
            pq.remove();
        }
    }
}