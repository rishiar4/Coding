class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index1 = 0, index2 = 0;
        for( int i = 0; i < nums.length-1; i++ )
        {
            for( int j = i+1; j < nums.length; j++ )
            {
                if( nums[i] + nums[j] == target )
                {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = index2;
        ans[1] = index1;
        return ans;
    }
}