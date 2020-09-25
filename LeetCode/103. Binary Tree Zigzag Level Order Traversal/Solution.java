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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if( root == null ) return res;

        List<Integer> ans;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add( root );

        int cnt = 0;

        while( qu.size() != 0 )
        {
            int size = qu.size();
            ans = new ArrayList<>();

            while( size > 0 )
            {
                TreeNode vtx = qu.remove();

                ans.add( vtx.val );

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                size--;
            }
            if( cnt == 1 )
            {
                List<Integer> a = new ArrayList<>();
                for( int i = ans.size() - 1; i >= 0; i-- )
                {
                    a.add( ans.get(i) );
                } 
                res.add( a );
            }
            else
            {
                res.add( ans );
            }
            cnt = ( cnt + 1 ) % 2;
        }
        return res;
    }
}