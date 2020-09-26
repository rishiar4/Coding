import java.util.Queue;
import java.util.LinkedList;
public class bfs{

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

    public static void bfs_01( Node root )
    {
        if( root == null ) return;

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );

        while( qu.size() != 0 )
        {
            Node vtx = qu.remove();
            System.out.print( vtx.data + " ");

            if( vtx.left != null ) qu.add( vtx.left );
            if( vtx.right != null ) qu.add( vtx.right );
            
        }

    }
    
    public static void main(String[] args) {
        int[] arr = { 10, 20, 40, -1, -1, 50, -1, -1, 30, 60, 80, -1, -1, 90, -1, -1, 70, 100, -1, -1, 110,-1,-1 };

        Node root = constructTree( arr );

        bfs_01( root );

    }
}