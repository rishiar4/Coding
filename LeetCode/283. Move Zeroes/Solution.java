class Solution {
    public void moveZeroes(int[] nums) {
        if( nums.length == 0 ) return;
        int pivot = -1, next = 0, n = nums.length ;
        while( next < n ){
            if( nums[next] != 0 ){
                swap( nums, next, ++pivot );
            }
            next++;
        }
    }
    public void swap( int[] nums, int a, int b ){
        int val1 = nums[a];
        int val2 = nums[b];

        nums[a] = val2;
        nums[b] = val1;
    }
}