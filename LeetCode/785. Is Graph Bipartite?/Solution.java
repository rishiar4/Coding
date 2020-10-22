class Solution {

    public boolean isBipartite( int[][] graph, int[] markedColor, int src )
    {
        LinkedList<Integer> qu = new LinkedList<>();
        qu.addLast( src );

        int color = 0;

        while( qu.size() != 0 )
        {
            int size = qu.size();
            while( size-- > 0 )
            {
                int vtx = qu.removeFirst();

                if( markedColor[vtx] != -1 )
                {
                    if( markedColor[vtx] != color )
                      return false;
                    continue;
                }

            markedColor[vtx] = color;

            for( int e : graph[vtx] )
            {
                if( markedColor[e] == -1 )
                 qu.addLast( e );
            }
         }
            color = ( color + 1 ) % 2;
        }
        return true;
    } 

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] markedColor = new int[N];
        Arrays.fill( markedColor, -1 );

        boolean ans = true;
        for( int i = 0; i < N; i++ )
        {
            if( markedColor[i] == -1 ){
               ans = isBipartite( graph, markedColor, i );

            if( !ans ) return false;
            }
        }
        return true;
    }
}