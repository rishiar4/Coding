import java.util.ArrayList;
public class l001{

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node( int data ){
            this.data = data;
        }
    }

    static int idx = 0;
    public static Node constructTree( int[] arr ){
        if( idx >= arr.length || arr[idx] == -1 ){
            idx++;
            return null;
        }

        Node node = new Node( arr[idx++] );
        node.left = constructTree( arr );
        node.right = constructTree( arr );

        return node;
    }

    public static void display( Node root ){
        if( root == null ) return;

        StringBuilder sb = new StringBuilder();

        sb.append( ( root.left == null ? "." : root.left.data + "" ) );
        sb.append( " <-- " + root.data + " --> " );
        sb.append( ( root.right == null ? "." : root.right.data + "" ) );
        System.out.println( sb );

        display( root.left );
        display( root.right );
    }

    public static void inOrder( Node root ){
        if( root == null ) return;

        inOrder( root.left );

        System.out.print( root.data + " ");

        inOrder( root.right );
    }

    public static void postOrder( Node root ){
        if( root == null ) return;

        postOrder( root.left );
        postOrder( root.right );

        System.out.print( root.data + " ");
    }

    public static void  preOrder( Node root ){
        if( root == null ) return;

        System.out.print( root.data + " ");
        preOrder( root.left );
        preOrder( root.right );

    }

    public static int size( Node root ){
        return root == null ? 0 : size( root.left ) + size( root.right ) + 1;
    }

    public static int height( Node root ){
        return root == null ? -1 : Math.max( height( root.left ), height( root.right ) ) + 1;
    }

    public static boolean find( Node root, int data ){
        if( root == null ) return false;

        if( root.data == data ) return true;

        return find( root.left, data ) || find( root.right, data );

    }

    public static boolean nodeToRootPath( Node root, int data, ArrayList<Node> ans ){
        if( root == null ){
            return false;
        }

        if( root.data == data ){
            ans.add( root );
            return true;
        }

        boolean res = nodeToRootPath( root.left, data, ans ) || nodeToRootPath( root.right, data, ans );
        if( res ){
            ans.add( root );
        }
        return res;
    }

    public static void main( String[] args ){
        int[] arr = { 10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1 };

        Node root = constructTree( arr );

        display( root );

        // inOrder( root );
        // postOrder( root );
        // preOrder( root );
        // System.out.println( size( root ) );
        // System.out.println( height( root ) );
        // System.out.println( find( root, 110 ) );
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath( root, 110, ans );
        for( Node nn : ans ){
            System.out.print( nn.data + " ");
        }


    }
}