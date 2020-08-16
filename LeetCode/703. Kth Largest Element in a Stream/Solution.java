class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int K = 0;
    public KthLargest(int k, int[] nums) {
        this.K = k;
        for( int ele : nums )
        {
            pq.add( ele );
            if( pq.size() > k )
            {
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add( val );
        if( this.pq.size() > K )
        {
            this.pq.remove();
        }   
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */