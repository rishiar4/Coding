import java.util.ArrayList;
public class l001{
    public static class Edge{
        int v = 0;
        int w = 0;

        public Edge( int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static int N = 7;  
    
    @SuppressWarnings("unchecked")
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge( int u, int v, int w){
        graph[u].add( new Edge(v, w));
        graph[v].add( new Edge(u, w));
    }

    public static void display(){
        for( int i = 0; i < N; i++){
            System.out.print( i + " --> ");
            for( Edge e : graph[i]){
                System.out.print( "( " + e.v + ", " + e.w + " ) " );
            }
            System.out.println();
        }
    }

    public static void constructGraph(){
        for( int i = 0; i < N; i++){
            graph[i] = new ArrayList<Edge>();
        }

        addEdge( 0, 1, 10);
        addEdge( 0, 3, 10);
        addEdge( 1, 2, 10);
        addEdge( 3, 2, 40);
        addEdge( 3, 4, 2);
        addEdge( 4, 5, 2);
        addEdge( 4, 6, 8);
        addEdge( 6, 5, 3);
    }

    public static int searchVtx( int u, int v){
        int idx = -1;
        for( int i = 0; i < graph[u].size(); i++){
            Edge e = graph[u].get(i);
            if( e.v == v){
                idx = i;
            }
        }
        return idx;
    }

    public static void removeEdge( int u, int v){
        int l1 = searchVtx( u, v);
        graph[u].remove(l1);

        int l2 = searchVtx( v, u);
        graph[v].remove(l2);
    }

    public static void removeVtx( int v){
        for( int i = graph[v].size() - 1; i >= 0; i--){
            Edge e = graph[v].get(i);
            removeEdge( v, e.v);
        }
    }

    public static boolean hasPath( int src, int des, boolean[] vis){
        if( src == des)
            return true;
        
        vis[src] = true;
        boolean res = false;
        for( Edge e : graph[src]){
            if( vis[e.v] == false){
                res = res || hasPath( e.v, des, vis);
            }
        }
        return res;
    }

    public static int allPath( int src, int des, boolean[] vis, String psf, int wsf){
        if( src == des ){
            System.out.println( psf + src + " @ " + wsf);
            return 1;
        }

        vis[src] = true;
        int count = 0;
        for( Edge e : graph[src]){
            if( !vis[e.v]){
                count += allPath( e.v, des, vis, psf + src + " ", wsf + e.w);
            }
        }

        vis[src] = false;
        return count;
    }

    public static void main(String[] args) {
        constructGraph();
        // removeEdge( 3, 4);
        // removeVtx( 3 );
        display();
        boolean[] vis = new boolean[N];
        // System.out.println( hasPath( 0, 6, vis));
        System.out.println( allPath( 0, 6, vis, "", 0) );
    }
}