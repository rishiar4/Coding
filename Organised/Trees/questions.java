public class questions{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 236. Lowest Common Ancestor of a Binary Tree
    public boolean nodeToRootPath( TreeNode root, TreeNode node, ArrayList<TreeNode> ans ){
        if( root == null ) return false;

        if( root == node ){
            ans.add( root );
            return true;
        }

        boolean res = nodeToRootPath( root.left, node, ans ) || nodeToRootPath( root.right, node, ans );

        if( res ) ans.add( root );

        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ans1 = new ArrayList<>();
        ArrayList<TreeNode> ans2 = new ArrayList<>();

        nodeToRootPath( root, p, ans1 );
        nodeToRootPath( root, q, ans2 );

        TreeNode LCA = null;

        int i = ans1.size() - 1;
        int j = ans2.size() - 1;

        while( i >= 0 && j >= 0 ){
            if( ans1.get(i) == ans2.get(j) ) LCA = ans1.get(i);

            i--;
            j--;
        }

        return LCA;
    }

    // 112. Path Sum
    public boolean hasPathSum(TreeNode root, int sum) {
     if( root == null ) return false;
     
     if( root.left == null && root.right == null && root.val == sum ) return true;

     boolean res = hasPathSum( root.left, sum - root.val ) || hasPathSum( root.right, sum - root.val );

     return res;
    }


    // 113. Path Sum II
    public void pathSum( TreeNode root, int sum, List<List<Integer>> res, List<Integer> ans ){
        if( root == null ) return;

        if( root.left == null && root.right == null && root.val == sum ){
            List<Integer> baseAns = new ArrayList<>( ans );
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

        pathSum( root, sum, res, new ArrayList<>() );

        return res;
    }
}