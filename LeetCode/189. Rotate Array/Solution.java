class Solution {
    public void swap( int[] nums, int a, int b ){
        int val1 = nums[a];
        int val2 = nums[b];

        nums[a] = val2;
        nums[b] = val1;
    }
    public void rotateArray( int[] nums, int i, int j ){
        while( i < j ) swap( nums, i++, j-- );
    }
    public void rotate(int[] nums, int k) {
        if( nums.length == 0 ) return;

        int n = nums.length;
        k = ( k % n + n ) % n;

        rotateArray( nums, 0, n - 1  );
        rotateArray( nums, 0, k - 1);
        rotateArray( nums, k, n - 1 );
    }
}