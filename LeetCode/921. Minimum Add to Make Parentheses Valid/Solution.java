class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        
        for( int i = 0; i < S.length(); i++ )
        {
            char ch = S.charAt( i );
            if( ch == '(' )
            {
                count++;
                st.push(i);
            }
            else if( ch == ')' )
            {
                if( st.size() == 0 )
                {
                    count++;
                }
                else if( S.charAt( st.peek() ) == '(' )
                {
                    st.pop();
                    count--;
                }
            }
        }
        return count;
    }
}