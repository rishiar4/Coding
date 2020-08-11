class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int index = -1;
        int mid = low + ( high - low )/2;
        while(low<=high){
            if(nums[mid] == target)
            {
                index = mid;
                return index;
            }
            else if(nums[mid]>target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
            mid = low + ( high - low )/2;
        }
        return index;
        
    }
}