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
    public static int[] diameter( TreeNode root )
    {
        if( root == null ) return new int[]{0,-1}; // dia , height
        
        int[] lRes = diameter( root.left );
        int[] rRes = diameter( root.right );
        
        int dia = Math.max( Math.max( lRes[0], rRes[0] ), lRes[1] + rRes[1] + 2 );
        int hei = Math.max( lRes[1], rRes[1] ) + 1;
        
        return new int[]{dia, hei};
    }
    public int diameterOfBinaryTree(TreeNode root) {
     int[] ans = diameter( root );  
        return ans[0];
    }
}