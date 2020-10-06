import java.util.ArrayList;

public class Solution{
    public static class Edge{
        int v = 0;
        int w = 0;

        Edge( int v, int w )
        {
            this.v = v;
            this.w = w;
        }
    }

    static int N = 7;
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge( int u, int v, int w )
    {
        graph[u].add( new Edge( v, w ) );
        graph[v].add( new Edge( u, w ) );
    }

    public static void constructGraph()
    {
        for( int i = 0; i < N; i++ )
            graph[i] = new ArrayList<>();
        
        addEdge( 0, 1, 10 );
        addEdge( 0, 3, 10 );
        addEdge( 1, 2, 10 );
        addEdge( 2, 3, 40 );
        addEdge( 3, 4, 2 );
        addEdge( 4, 5, 2 );
        addEdge( 4, 6, 8 );
        addEdge( 5, 6, 3 );

    }

    public static void show()
    {
        for( int i = 0; i < N; i++ )
        {
            System.out.print( i + " --> ");
            for( Edge e : graph[i] )
            {
                System.out.print( "( " + e.v + " , " + e.w + " ) " );
            }
            System.out.println();
        }
    }

    public static int searchVTX( int u, int v )
    {
        for( int i = 0; i < graph[u].size(); i++ )
        {
            Edge e = graph[u].get(i);
            if( e.v == v ) return i;
        }
        return -1;
    }

    public static void removeEdge( int u, int v )
    {
        int l1 = searchVTX( u, v );
        graph[u].remove( l1 );

        int l2 = searchVTX( v, u );
        graph[v].remove( l2 );
    }

    public static void main(String[] args) {
        
        constructGraph();

        show();
        System.out.println("========================================");
        removeEdge( 2, 3 );
        show();
    }
}