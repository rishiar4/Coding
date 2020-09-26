import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class leftView{

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

    public static ArrayList<Node> lView( Node root )
    {
        ArrayList<Node> ans = new ArrayList<>();

        if( root == null ) return ans;

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );

        while( qu.size() != 0 )
        {
            ans.add( qu.peek() );
            int size = qu.size();

            while( size > 0 )
            {
                Node vtx = qu.remove();

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                size--;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = { 10, 20, 40, -1, -1, 50, -1, -1, 30, 60, 80, -1, -1, 90, -1, -1, 70, 100, -1, -1, 110,-1,-1 };

        Node root = constructTree( arr );

        ArrayList<Node> ans = lView( root );

        for( Node node : ans ) System.out.print( node.data + " " );

    }
}