class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        for( int i = 0; i < nums1.length; i++ )
        {
           hs.add( nums1[i] );
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for( int i = 0; i < nums2.length; i++ )
        {
            if( hs.contains( nums2[i] ) )
            {
                ar.add( nums2[i] );
                hs.remove( nums2[i]);
            }
        }
        int ans[] = new int[ ar.size() ];
        
        for( int i = 0; i < ar.size(); i++ )
        {
            ans[i] = ar.get( i );
        }
        return ans;
    }
}