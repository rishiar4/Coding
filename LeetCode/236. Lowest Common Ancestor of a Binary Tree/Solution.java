/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static boolean nodeToRootPath( TreeNode root, int data, ArrayList<TreeNode> ans )
    {
        if( root == null ) return false;

        if( root.data == data )
        {
            ans.add( root );
            return true;
        } 

        boolean res = nodeToRootPath( root.left, data, ans ) || nodeToRootPath( root.right, data, ans );
        if( res )
        {
            ans.add( root );
        }

        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        nodeToRootPath( root, p.val, list1 );
        nodeToRootPath( root, q.val, list2 );

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        TreeNode LCA = null;

        while( i >= 0 && j >= 0 )
        {
            if( list1.get(i) == list2.get(j) ) LCA = list1.get(i);

            i--;
            j--;
        }

        return LCA;

    }
}