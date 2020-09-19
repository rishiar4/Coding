public class Solution{
    
    // Size of the binary tree

    public static int size( Node root)
    {
        return ( root == null ? 0 : 1 + size( node.left ) + size( node.right ) );
    }
}