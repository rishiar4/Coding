class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for( int[] p : points )
        {
            pq.add( p );
            if( pq.size() > K )
            {
                pq.remove();
            }
        }
        int[][] ans = new int[ pq.size() ][ 2 ];
        int c = 0;
        while( pq.size() != 0 )
        {
            ans[ c ] = pq.remove();
            c++;
        }
        return ans;
    }
}