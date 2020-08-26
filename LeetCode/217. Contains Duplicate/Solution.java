class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for( int i = 0 ; i < nums.length; i++ )
        {
            if( hs.contains(nums[i]) == false  )
                hs.add( nums[i] );
        }
        
        if( hs.size() == nums.length )
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}