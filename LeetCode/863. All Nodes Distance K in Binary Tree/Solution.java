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

    public boolean nodeToRootPath( TreeNode root, TreeNode target, List<TreeNode> path )
    {
        if( root == null  ) return false;

        if( root == target ) 
        {
            path.add( root );
            return true;
        }

        boolean res = nodeToRootPath( root.left, target, path ) || nodeToRootPath( root.right, target, path );
        if( res ) path.add( root );
        
        return res;
    }

    public void kDown( TreeNode root, TreeNode block, int k, List<Integer> res)
    {
        if( root == null || root == block || k < 0 ) return;

        if( k == 0 ) {
            res.add( root.val );
            return;
        }

        kDown( root.left, block, k - 1, res );
        kDown( root.right, block, k - 1, res );
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        if( root == null ) return ans;
        
        List<TreeNode> path = new ArrayList<>();
        nodeToRootPath( root, target, path);
        // for( TreeNode nn : path ) System.out.print( nn.val + " ");

        TreeNode prev = null;
        for( int i = 0; i < path.size(); i++ )
        {
            kDown(  path.get( i ), prev,K - i , ans );
            prev = path.get( i );
        }
        return ans;
    }
}