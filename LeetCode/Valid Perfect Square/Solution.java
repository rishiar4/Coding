class Solution {
    public boolean isPerfectSquare(int num) {
        
        long  i = 0;
        
        while(i*i <= num){
            if(i*i==num)
                return true;
            else
                i++;
        }
        return false;
        
    }
}


