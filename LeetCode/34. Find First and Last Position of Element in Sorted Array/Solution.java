class Solution {
    public int firstBinarySearch( int[] arr, int data){
        int low = 0, high = arr.length - 1;

        while( low <= high){
            int mid = ( high + low )/2;

            if( arr[mid] == data ){
                if( mid - 1 >= 0 && arr[mid-1] == data)
                    high = mid - 1;
                else
                    return mid;
            }
            else if( arr[mid] > data)
                high = mid - 1;
            else
                low = mid + 1;
            }
            return -1;  
    }

    public int lastBinarySearch( int[] arr, int data){
        int low = 0, high = arr.length - 1;

        while( low <= high){
            int mid = (low + high)/2;

            if( arr[mid] == data){
                if( mid + 1 < arr.length && arr[ mid + 1 ] == data){
                    low = mid + 1;
                }else{
                    return mid;
                }
            }else if( arr[mid] > data){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = firstBinarySearch( nums, target);
        ans[1] = lastBinarySearch( nums, target);

        return ans;
    }
}