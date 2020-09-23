/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ArrayList<TreeNode> leftView( TreeNode root )
    {
        Queue<TreeNode> qu = new LinkedList<>();
        ArrayList<TreeNode> ans = new ArrayList<>(); 
        qu.add( root );

        while( qu.size() != 0 )
        {
            int size = qu.size();
            ans.add( qu.peek() );
            while( size > 0 )
            {
                TreeNode vtx = qu.remove();
                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );
                size--;
            }
        }
        return ans;
    }
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<TreeNode> ans = leftView( root );
        TreeNode a =  ans.get( ans.size() - 1 );
        return a.val;
    }
}