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
    @SuppressWarnings("unchecked")
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

           addEdge(0,1,10);
           addEdge(0,3,10);
           addEdge(1,2,10);
           addEdge(2,3,40);
           addEdge(3,4,2);
           addEdge(4,5,2);
           addEdge(4,6,8);
           addEdge(5,6,3);

    }

    public static void show()
    {
        for( int i = 0; i < N; i++ )
        {
            System.out.print( i + " --> ");
            for( Edge e : graph[i] )
             System.out.print( "( " + e.v + ", " + e.w + " ) ");
            System.out.println();
        }
    }

    public static class pair{
        int weight = 0;
        String path = "";

        pair( int weight, String path )
        {
            this.weight = weight;
            this.path = path;
        }
    }

    public static pair maxPath( int src, int des, boolean[] vis )
    {
        if( src == des )
        {
            return new pair( 0, src + "" );
        }

        vis[src] = true;
        pair myAns = new pair( 0, "");
        
        for( Edge e : graph[src] )
        {
            if( vis[e.v] == false )
            {
                pair recAns = maxPath( e.v, des, vis );
                if( recAns.weight + e.w > myAns.weight )
                {
                    myAns.weight = recAns.weight + e.w;
                    myAns.path = src + " " + recAns.path;
                }
            }
        }

        vis[src] = false;

        return myAns;
    }

    public static void main( String[] args )
    {
        constructGraph();

        show();
        
        System.out.println();
        
        pair ans = maxPath( 0, 6, new boolean[graph.length] );

        System.out.println( ans.path + " @ " + ans.weight );
    }

}