class Solution {
    public void reverseString(char[] s) {
         
        if(s.length == 0)
            return;
        
        for( int i = 0; i < s.length/2; i++ )
        {
            char c = s[i];
            s[i] = s[ s.length -1 -  i ];
            s[ s.length - 1 - i ] = c;
        }
    }
}