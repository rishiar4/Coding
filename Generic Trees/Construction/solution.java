import java.util.ArrayList;
import java.util.Stack;

public class solution{
    public static class Node{
        int data;
        ArrayList<Node> children;

        Node( int data )
        {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static void display( Node root )
    {
        StringBuilder sb = new StringBuilder();
        sb.append( root.data + " --> "  );
        for( Node node : root.children )
        {
            sb.append( node.data + " " );
        }
        System.out.println( sb.toString() );

        for( Node node : root.children )
        {
            display( node );
        }
    }

    public static Node constructTree( int[] arr )
    {
        Stack<Node> st = new Stack<>();
        for( int i = 0; i < arr.length - 1; i++ )
        {
            int ele = arr[i];
            if( ele != -1 ) st.push( new Node( ele ) );
            else 
            {
                Node vtx = st.pop();
                st.peek().children.add( vtx );
            }
        }
        return st.pop();
    }

    public static void main( String[] args )
    {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
        Node root = constructTree( arr );
        display( root );
    }
}