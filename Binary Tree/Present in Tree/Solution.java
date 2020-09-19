public class Solution{

    public static boolean find( Node root, int data )
    {
        if( root == null ) return false;

        if( root.data == data ) return true;

        return find( root.left, data ) || find( root.right, data );
    }
}