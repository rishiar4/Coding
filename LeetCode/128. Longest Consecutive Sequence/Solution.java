class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for( int ele : nums )
        {
            hs.add( ele );
        }
        int length = 0;
        
        for( int ele : nums )
        {
            if( ! hs.contains( ele ) )
                continue;
            int prev = ele -1;
            int next = ele + 1;
            
            while( hs.contains( prev ) )
            {
             hs.remove( prev );
             prev--;   
             
            }
            
            while( hs.contains(next))
            {
                hs.remove( next );
                next++;
            }
            length = Math.max( length, ( next - prev - 1 ) );
        }
     return length;   
    }
}