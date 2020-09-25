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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        if( root == null ) return res;

        qu.add( root );
        Stack<List<Integer>> st = new Stack<>();
        List<Integer> ans;
        while( qu.size() != 0 )
        {
            int size = qu.size();
            ans =  new ArrayList<>();

            while( size > 0 )
            {
                TreeNode vtx = qu.remove();
                ans.add( vtx.val );

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                size--;
            }
            st.push( ans );
        }
        while( st.size() != 0 )
        {
            res.add( st.pop() );
        }
        return res;
    }
}