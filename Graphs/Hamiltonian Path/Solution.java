import java.util.ArrayList;
public class Solution{

    public static class Edge{
        int v; 
        int w;

        public Edge( int v, int w )
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

    public static void construct()
    {
        for( int i = 0; i < N; i++ )
          graph[i] = new ArrayList<>();

        addEdge( 0, 1, 10 );
        addEdge( 0, 3, 10 );
        addEdge( 1, 2, 10 );
        addEdge( 2, 3, 10 );
        addEdge( 3 , 4, 2 );
        addEdge( 4, 5, 2 );
        addEdge( 4, 6, 8 );
        addEdge( 5, 6, 3 );
        addEdge( 2, 5, 10 );
    }

    public static void display()
    {
        for( int i = 0; i < N; i++ )
        {
            System.out.print( i + " ---> ");
            for( Edge e :graph[i] )
            {
                System.out.print( " ( " + e.v + " , " + e.w + " ) ");
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

    public static int hamPath( int src, int osrc, int edgeCount, boolean[] vis, String psf )
    {
        if( edgeCount == N - 1 )
        {
            int l1 = searchVTX( src, osrc );
            psf = psf + src;
            if( l1 == -1 ) 
              System.out.println( "Path : " + psf );
            else
              System.out.println("Cycle : " + psf );
            
            return 1;
        }

        vis[src] = true;
        int count = 0;

        for( Edge e : graph[src] )
        {
            if( !vis[e.v] )
            count += hamPath( e.v, osrc, edgeCount + 1, vis, psf + src + " ");
        }

        vis[src] = false;

        return count;
    }
    
    public static void main(String[] args) {
        construct();
        display();
        System.out.println( hamPath( 0, 0, 0, new boolean[graph.length], "" ) ) ; 
    }
}