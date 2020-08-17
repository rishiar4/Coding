class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for( int i = 0; i < nums1.length; i++ )
        {
            hm.put( nums1[i], hm.getOrDefault( nums1[i], 0 ) + 1 );
        }
        
        System.out.println( hm.keySet() );
        ArrayList<Integer> arr = new ArrayList<>();
        for( int i = 0; i < nums2.length; i++ )
        {
            if( hm.containsKey(nums2[i]))
            {
                int val = hm.get( nums2[i] );
                if( val == 1 )
                {
                    arr.add( nums2[i] );
                    hm.remove( nums2[i] );
                }
                else{
                    arr.add( nums2[i] );
                    hm.put( nums2[i], val - 1 ); 
                }
            }
        }
        
         int ans[] = new int[ arr.size() ];
        
        for( int i = 0; i < arr.size(); i++ )
        {
            ans[i] = arr.get( i );
        }
        return ans;
    }
}