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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add( root );

        while( qu.size() != 0 )
        {
            int size = qu.size();
            int n = size;
            Double res = 0.0;

            while( size > 0 )
            {
                TreeNode vtx = qu.remove();

                res += vtx.val;

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                size--;
            }
            ans.add( res/n );
        }
        return ans;
    }
}