public class avl{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        int height = 0;
        int bal = 0;

        Node( int data )
        {
            this.data = data;
        }
    }

    public static void updateHeightAndBalance( Node root )
    {
        int lh = -1;
        int rh = -1;

        if( root.left != null ) lh = root.left.height;
        if( root.right != null ) rh = root.right.height;

        root.height = Math.max( lh, rh ) + 1;
        root.bal = lh - rh;
    }

    public static Node rightRotation( Node A )
    {
        Node B = A.left;
        Node bKaRight = B.right;

        B.right = A;
        A.left = bKaRight;

        updateHeightAndBalance( A );
        updateHeightAndBalance( B );
        
        return B;
    }
    
    public static Node leftRotation( Node A )
    {
        Node B = A.right;
        Node bKaLeft = B.left;

        B.left = A;
        A.right = bKaLeft;

        updateHeightAndBalance( A );
        updateHeightAndBalance( B );
        
        return B;
    }

    public static Node getRotation( Node root )
    {
        updateHeightAndBalance( root );

        if( root.bal == 2 )
        {
            if( root.left.bal == 1 )
            {
                return rightRotation( root );
            }
            else if( root.left.bal == -1 )
            {
                root.left = leftRotation( root.left );
                return rightRotation( root );
            }
        }
        else if( root.bal == -2 )
        {
            if( root.right.bal == -1 )
            {
                return leftRotation( root );
            }
            else if( root.right.bal == 1 )
            {
                root.right = rightRotation( root.right );
                return leftRotation( root );
            }
        }
        
        return root;
    }

    public static void display( Node root )
    {
        if( root == null ) return;

        StringBuilder sb = new StringBuilder();
        sb.append( root.left == null ? "." : root.left.data );
        sb.append( " <-- " + root.data + " --> ");
        sb.append( root.right == null ? "." : root.right.data );
        System.out.println( sb.toString() );

        display( root.left );
        display( root.right );
    }
    public static Node insertIntoAVL( Node root, int val )
    {
        if( root == null ) return new Node( val );
        
        if( root.data > val ) root.right = insertIntoAVL( root.right, val );
        else
          root.left = insertIntoAVL( root.left, val );
        
        return getRotation(root);
    }
    public static int getMax( Node root )
    {
        if( root == null ) return -(int)1e8;

        Node curr = root;
        while( curr.right != null )
        {
            curr = curr.right;
        }
        return curr.data;
    }
    public static Node deleteNode( Node root, int val )
    {
        if( root == null ) return null;

        if( root.data > val ) root.right = deleteNode( root.right, val );
        else if( root.data < val ) root.left = deleteNode( root.left, val );
        else
        {
            if( root.left == null || root.right == null )
            {
                return ( root.left != null ? root.right : root.left );
            }
            int mVal = getMax( root.left );
            root.data = mVal;
            root.left = deleteNode( root.left, mVal );
        }
        return getRotation( root );
    }

    public static void main(String[] args) {
        Node root = null;
        for( int i = 1; i < 14; i++ )
        {
            root = insertIntoAVL( root, i * 10 );
        }
        root = deleteNode( root, 120 );
        display( root );
        
    }

}