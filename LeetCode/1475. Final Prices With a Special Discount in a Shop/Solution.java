class Solution {
    public int[] finalPrices(int[] prices) {
        
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[prices.length];
        for( int i = prices.length - 1; i >= 0; i-- )
        {
            while( st.size() != 0 && prices[st.peek()] > prices[i] )
            {
                st.pop();
            }
            if( st.size() == 0)
            {
                ans[i] = -1;
            }
            else
            {
                ans[i] = st.peek();
            }
            st.push(i);
            }
        
        for( int i = 0; i < prices.length; i++ )
        {
            if( ans[i] != -1 )
            {
                prices[i] = prices[i] - prices[ans[i]];
            }
        }
        return prices;
    }
}