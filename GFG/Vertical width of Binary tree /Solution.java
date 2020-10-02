public class Solution{

    public static void width( Node root, int level, int[] maxMin )
    {
        if( root == null ) return;

        maxMin[0] = Math.max( level, maxMin[0] );
        maxMin[1] = Math.min( level, maxMin[1] );

        width( root.left, level - 1, maxMin );
        width( root.right, level + 1, maxMin );
    }

    public static int VerticalWidth( Node root )
    {
        int[] maxMin = new int[2];
        width( root, 0, maxMin );

        return maxMin[0] - maxMin[1] + 1;
    }
}