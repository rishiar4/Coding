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
    public int height( TreeNode root ){
        return root == null ? -1 : Math.max( height(root.left), height(root.right) ) + 1;
    }
    public int diameter( TreeNode root ){
        if( root == null ) return 0;

        int lD = diameter( root.left );
        int rD = diameter( root.right );

        int lH = height( root.left );
        int rH = height( root.right );

        return Math.max( Math.max( lD, rD ), lH + rH + 2 );
    }

    public int[] diameter_02( TreeNode root ){
        if( root == null ) return new int[]{ 0, -1 };

        int lRes[] = diameter_02( root.left );
        int rRes[] = diameter_02( root.right );

        int dia = Math.max( Math.max(lRes[0],rRes[0]), lRes[1] + rRes[1] + 2 );
        int hei = Math.max( lRes[1], rRes[1] ) + 1;

        return new int[]{ dia, hei };
    }

    static int diaAns = 0;
    public int diameter_03( TreeNode root ){
        if( root == null ) return -1;

        int lH = diameter_03( root.left );
        int rH = diameter_03( root.right );

        diaAns = Math.max( diaAns, lH + rH + 2 );

        return Math.max( lH, rH ) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // return diameter( root );
        return diameter_02( root )[0];
        // if( root == null ) return 0;
        // diameter_03( root );
        // return diaAns;
    }
}