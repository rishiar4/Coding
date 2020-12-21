public class l002{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node( int data ){
            this.data = data;
        }
    }

    public static Node constructTree( int[] arr, int si, int ei ){
        if( si > ei ) 
            return null;

        int mid = ( si + ei )/2;

        Node node = new Node( arr[mid] );
    
        node.left = constructTree( arr, si, mid - 1 );
        node.right = constructTree( arr, mid + 1, ei );

        return node;
    }

    public static void display( Node root ){
        if( root == null ) return;

        StringBuilder sb = new StringBuilder();
        sb.append( root.left == null ? "." : root.left.data );
        sb.append(" <-- " + root.data + " --> ");
        sb.append( root.right == null ? "." : root.right.data );
        
        System.out.println( sb.toString() );

        display( root.left );
        display( root.right );
    }

    public static int size( Node root ){
        return root == null ? 0 : size( root.left ) + size( root.right ) + 1;
    }

    public static int height( Node root ){
        return root == null ? -1 : Math.max( height( root.left ), height( root.right ) ) + 1;
    }

    public static int maximum( Node root ){
        Node curr = root;

        while( curr.right != null ){
            curr = curr.right;
        }

        return curr.data;
    }

    public static int minimum( Node root ){
        Node curr = root;

        while( curr.left != null ){
            curr = curr.left;
        }

        return curr.data;
    }

    public static boolean find( Node root, int data ){
        Node curr = root;

        while( curr != null ){
            if( curr.data == data )
                return true;
            else if( curr.data > data ) 
                curr = curr.left;
            else 
                curr = curr.right;
        }

        return false;
    }

    public static void main( String[] args ){
        int[] arr = new int[20];
        for( int i = 0; i < arr.length; i++ ){
            arr[i] = i * 10; 
        }

        Node root = constructTree( arr, 0, arr.length - 1 );
        // display( root );
        // System.out.println( size(root) );
        // System.out.println( height(root) );
        // System.out.println( maximum( root ) );
        // System.out.println( minimum( root ) );
        System.out.println( find( root, 95 ) );
    }
}