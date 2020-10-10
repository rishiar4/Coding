public class Solution{
    public static int height( Node root )
    {
        return root == null ? -1 : Math.max( height(root.left), height(root.right) ) + 1;
    }


    public static int diameter( Node root )
    {
        if( root == null ) return 0;

        int ld = diameter( root.left );
        int rd = diameter( root.right );

        int lh = height( root.left );
        int rh = height( root.right );

        return Math.max( Math.max( ld, rd ), lh + rh + 2 );
    }
}