import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution{
    public static class Edge{
        int v;
        int w; 

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
        graph[u].add( new Edge(v,w));
        graph[v].add( new Edge(u,w));
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

    public static void display()
    {
        for( int i = 0; i < graph.length; i++ )
        {
            System.out.print( i + " --> ");
            for( Edge e : graph[i] )
            {
                System.out.print( "( " + e.v + " , " + e.w + " ) ");
            }

            System.out.println();
        }
    }

    public static void BFS( int src, int des, boolean[] vis )
    {
        Queue<Integer> qu = new LinkedList<>();
        qu.add( src );

        boolean isCycle = false;
        int level = 0;
        
        while( qu.size() != 0 )
        {
            int size = qu.size();
            while( size > 0 )
            {
                int vtx = qu.remove();
                size--;

                if( vis[vtx] )
                {
                    isCycle = true;
                    continue;
                }

                if( vtx == des )
                {
                    System.out.println( level );
                }

                vis[vtx] = true;

                for( Edge e : graph[vtx] )
                {
                    if( !vis[e.v] )
                    {
                        qu.add( e.v );
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        constructGraph();
        display();

        boolean[] vis = new boolean[graph.length];
        
        BFS( 0, 6, vis );
    }
}