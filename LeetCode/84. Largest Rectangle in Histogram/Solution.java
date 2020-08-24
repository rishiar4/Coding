class Solution {
    public int largestRectangleArea(int[] heights) {
        if( heights.length == 0 )
        {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        st.push( -1 );
        int area = 0;
        for( int i = 0; i < heights.length; i++ )
        {
            while( st.peek() != -1 && heights[i] <= heights[st.peek()] )
            {
                int h = heights[st.pop()];
                int w = i - 1 - st.peek();
                
                area = Math.max( area, h * w );
            }
            st.push( i );
        }
        
            while( st.peek() != -1 )
            {
                int h = heights[st.pop()];
                int w = heights.length - 1 - st.peek();
                
                area = Math.max( area, h * w );
            }
        return area;
    }
}