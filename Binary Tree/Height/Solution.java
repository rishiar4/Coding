public class Solution{

    public static int height( Node root )
    {
        return ( root == null ? -1 : height( root.left ) + height( root.right ) + 1 );
    }
}