public class Solution
{
    public static boolean NodeToRootPath( Node root, int data, ArrayList<Node> ans )
    {
        if( root == null ) return false;

        if( root.data == data ) {
            ans.add( root );
            return true;
        }

        boolean res = NodeToRootPath( root.left, data, ans ) || NodeToRootPath( root.right, data, ans );
        if( res )
        {
            ans.add( root );
        }
        return res;
    }

    public static ArrayList<Node> NodeToRootPath_02( Node root, int data )
    {
        if( root == null )
        {
            return null;
        }

        if( root.data == data )
        {
            ArrayList<Node> baseAns = new ArrayList<>();
            baseAns.add( root );
            return baseAns;
        }

        ArrayList<Node> left = nodeToRootPath(root.left,data);
        if(left!=null){
            left.add(root);
            return left;
        }

        ArrayList<Node> right = nodeToRootPath(root.right,data);
        if(right!=null){
            right.add(root);
            return right;
        }

        return null;
    }

    public static ArrayList<Node> NodeToRootPath_03( Node root, int data )
    {
        if( root == null ) return new ArrayList<Node>();

        if( node.data == data )
        {
            ArrayList<Node> baseAns = new ArrayList<>();
            baseAns.add( root.data );
            return baseAns;
        }

        ArrayList<Node> leftAns = NodeToRootPath_03( root.left, data );
        if( leftAns.size() > 0 )
        {
            leftAns.add( root.data );
            return leftAns;
        }

        ArrayList<Node> rightAns = NodeToRootPath_03( root.right, data );
        if( rightAns.size() > 0 )
        {
            rightAns.add( root.data );
            return rightAns;
        }

        return rightAns;
    }
}