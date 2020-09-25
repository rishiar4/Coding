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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add( root );

        while( qu.size() != 0 )
        {
            int size = qu.size();
            int lMax = Integer.MIN_VALUE;
            
            while( size > 0 )
            {
                TreeNode vtx = qu.remove();

                lMax = Math.max( lMax, vtx.val );
                
                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                size--;
            }
            res.add( lMax );
        }
        return res;
    }
}