class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for( int i = 0; i < nums.length; i++ )
        {
            if( hm.containsKey(nums[i]) )
            {
                return nums[i];
                // hm.put( nums[i], hm.get(nums[i]) + 1 );
            }
            else
            {
                hm.put( nums[i], 1 );
            }
        }
        return -1;
    }
}