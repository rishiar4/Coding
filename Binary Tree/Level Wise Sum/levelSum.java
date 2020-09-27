import java.util.LinkedList;
import java.util.Queue;

public class levelSum{
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

        Node nn = new Node( arr[idx++] );
        nn.left = constructTree( arr );
        nn.right = constructTree( arr );

        return nn;
    }

    public static void lSum( Node root )
    {
        if( root == null ) return;

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );

        while( qu.size() != 0 )
        {
            int size = qu.size();
            int summ = 0;

            while( size > 0 )
            {
                Node vtx = qu.remove();

                summ+= vtx.data;

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                size--;
            }
            System.out.println( summ );
        }
    }

    public static void main(String[] args) {
         
        int[] arr = {10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree( arr );
        lSum( root );
    }
}