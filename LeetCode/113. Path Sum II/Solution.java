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
    public void pathSum( TreeNode root, int sum,  List<List<Integer>> res, List<Integer> ans )
    {
        if( root == null) return;

        if( root.left == null && root.right == null && root.val == sum )
        {
            List<Integer> baseAns = new ArrayList<>(ans);
            baseAns.add( root.val );
            res.add( baseAns );
            return;
        }

        ans.add( root.val );
        pathSum( root.left, sum - root.val, res, ans );
        pathSum( root.right, sum - root.val, res, ans );
        ans.remove( ans.size() - 1 );
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;

        pathSum( root, sum, res, new ArrayList<Integer>() );
        return res;
    }
}