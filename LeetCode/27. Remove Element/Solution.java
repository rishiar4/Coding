class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for( int i = 0; i < nums.length - idx; i++ )
        {
            if( nums[i] == val )
            {
                int temp = nums[nums.length - 1 - idx ];
                nums[ nums.length - 1 - idx ] = nums[i];
                nums[i] = temp;
                idx++;
                i--;
            }
        }
        return nums.length - idx;
    }
}