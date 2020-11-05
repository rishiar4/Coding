class Solution {

    public int LIS( int[] nums, int idx, int[] dp){
        
        if( dp[idx] != -1 ) return dp[idx]; 

        int maxLen = 1;
        for( int i = idx - 1; i >= 0; i-- ){
            if( nums[i] < nums[idx] ){
                int len = LIS( nums, i, dp ) + 1;
                maxLen  = Math.max( maxLen, len );
            }
        }
        return maxLen;
    }

    public int LISDP( int[] nums, int[] dp ){
        int n = nums.length;
        int maxLen = 0;
        for( int i = 0; i < n; i++ ){
            dp[i] = 1;
            for( int j = i - 1; j >= 0; j-- ){
                if( nums[i] > nums[j] ){
                    dp[i] = Math.max( dp[i], dp[j]  + 1);
                }
            }
            maxLen = Math.max( maxLen, dp[i]);
        }
        return maxLen;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        // int maxLen = 0;
        // for( int i = n - 1; i >= 0; i-- ){
        //     maxLen = Math.max( maxLen, LIS( nums, i, dp ) );
        // }
        // return maxLen; 

        return LISDP( nums, dp);
    }
}