public class questions{
    // 863. All Nodes Distance K in Binary Tree
    public static boolean nodeToRootPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if(root==null){
            return false;
        }
        if( root.val == target.val ){
            path.add(root);
            return true;
        }

        boolean res = nodeToRootPath(root.left, target, path) || nodeToRootPath(root.right, target, path);
        if( res ){
            path.add(root);
        }
        return res;
    }
    public static void kDown(TreeNode root, TreeNode block, int k, ArrayList<Integer> ans){
        if( root == null || k < 0 || root == block ){
            return;
        }
        if(k==0){
            ans.add(root.val);
            return;
        }

        kDown(root.left, block, k - 1, ans);
        kDown(root.right, block, k - 1, ans);

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> path = new ArrayList<>();
        nodeToRootPath(root, target, path); 

        List<Integer> ans = new ArrayList<>();

        TreeNode block = null;
        for(int i = 0; i < path.size(); i++){
            kDown(path.get(i), block, k-i, ans);
            block = path.get(i);
        }
        return ans;
    }
}