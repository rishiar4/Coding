class Solution {
    public void sortColors(int[] nums) {
        if( nums.length == 0 ) return;
        int pivot = -1, ePivot = nums.length - 1, next = 0;
        while( next <= ePivot ){
            if( nums[next] == 0 ){
                swap( nums, next++, ++pivot ); 
            }else if( nums[next] == 2 ){
                swap( nums, next, ePivot-- );
            }else next++;
        }
    }
    public void swap( int[] nums, int a, int b ){
        int val1 = nums[a];
        int val2 = nums[b];

        nums[a] = val2;
        nums[b] = val1;
    }
}