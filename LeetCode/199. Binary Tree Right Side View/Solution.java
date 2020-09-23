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
    public List<Integer> rightSideView(TreeNode root) {
        if( root == null ) return new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        qu.add( root );

        while( qu.size() != 0 )
        {
            int size = qu.size();
            while( size > 0 )
            {
                TreeNode vtx = qu.remove();
                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                if( size == 1 )
                {
                    ans.add( vtx.val );
                }
                size--;
            }
        }
        return ans;
    }
}