import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class vSum{

    public static class Node{
        int data; 
        Node left;
        Node right;

        Node( int data )
        {
            this.data = data;
        }
    }

    static int idx = 0;
    public static Node constructTree( int[] arr )
    {
        if( idx >= arr.length || arr[idx] == -1 )
        {
            idx++;
            return null;
        }

        Node node = new Node( arr[ idx++ ] );
        node.left = constructTree( arr );
        node.right = constructTree( arr );

        return node;

    }

    public static class pair{
        int v = 0;
        Node node = null;

        pair( Node node, int v )
        {
            this.node = node;
            this.v = v;
        }
    }

    public static void width( Node root, int level, int[] maxMin )
    {
        if( root == null ) return;

        maxMin[0] = Math.max( level, maxMin[0] );
        maxMin[1] = Math.min( level, maxMin[1] );

        width( root.left, level - 1, maxMin );
        width( root.right, level + 1, maxMin );
    }

    public static int[] vSum( Node root )
    {
        int[] maxMin = new int[2];
        width( root, 0, maxMin );

        int n = maxMin[0] - maxMin[1] + 1;
        int[] ans = new int[n];

        Queue<pair> qu = new LinkedList<>();
        qu.add( new pair(root, -maxMin[1]) );

        while( qu.size() != 0 )
        {
            int size = qu.size();

            while( size > 0 )
            {
                pair vtx = qu.remove();

                ans[vtx.v] += vtx.node.data;

                if( vtx.node.left != null ) qu.add( new pair( vtx.node.left, vtx.v - 1 ) );
                if( vtx.node.right != null ) qu.add( new pair( vtx.node.right, vtx.v + 1 ) );

                size--;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = { 10, 20, 40, -1, -1, 50, -1, -1, 30, 60, 80, -1, -1, 90, -1, -1, 70, 100, -1, -1, 110,-1,-1 };

        Node root = constructTree( arr );

        int[] ans = vSum( root );

        for( int a : ans )
           System.out.print( a + " ");

    }
}