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
   public int maximalRectangle(char[][] matrix) {
       if( matrix.length == 0 || matrix[0].length == 0)
       {
           return 0;
       }
       int area = 0;
       int[] pmatrix = new int[matrix[0].length];
       for( int i = 0; i < matrix.length; i++ )
       {
           for( int k = 0; k < matrix[0].length; k++ )
           {
           
               int c = matrix[i][k]-'0';
               if( c == 0 )
               {
                   pmatrix[k] = 0;
               }
               else
               {
                   pmatrix[k]+= c;
               }
           }
           area = Math.max( area,largestRectangleArea(pmatrix) );
       }
       return area;
   }
}