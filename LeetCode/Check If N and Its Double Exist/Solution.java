class Solution {
    public boolean checkIfExist(int[] arr) {
        
        for(int i = 0; i < arr.length; i++ )
        {
            int val = arr[i];
            for(int j = 0; j < arr.length; j++ )
            {
                if( i!=j && val == arr[j] * 2 )
                {
                    return true;
                }
            }
        }
        return false;    
    }
}