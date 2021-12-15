import java.util.ArrayList;
public class l001{
    public static class TreeNode{
        int data = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int data){ 
            this.data = data;
        }
    }

    static int idx = 0;
    public static TreeNode constructTree(int[] arr){
        if( idx >= arr.length || arr[idx] == -1){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(arr[idx++]);
        node.left = constructTree(arr);
        node.right = constructTree(arr);

        return node;
    }

    public static void display(TreeNode root){
        if( root == null ){
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append( root.left != null ? root.left.data : " ");
        sb.append(" <-- " + root.data + " --> ");
        sb.append( root.right != null ? root.right.data : " ");
        System.out.println( sb.toString() );

        display(root.left);
        display(root.right);
    }

    public static int size(TreeNode root){
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root){
        return root == null ? -1 : Math.max( height(root.left), height(root.right) ) + 1;
    }

    public static int maximum(TreeNode root){
        return root == null ? -(int)1e8 : Math.max( Math.max( maximum(root.left), maximum(root.right) ), root.data );
    }

    public static int minimum(TreeNode root){
        return root == null ? (int)1e8 : Math.min( Math.min(minimum(root.left), minimum(root.right)), root.data );
    }

    public static boolean find(TreeNode root, int data){
        if(root==null){
            return false;
        }
        
        if(root.data == data){
            return true;
        }

        return find(root.left, data) || find(root.right, data);
    }

    public static int sum( TreeNode root ){
        return root == null ? 0 : sum(root.left) + sum(root.right) + root.data;
    } 

    public static void preOrder(TreeNode root){
        if( root == null ){
            return;
        }

        System.out.println( root.data );
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root){
        if( root == null ){
            return;
        }

        inOrder(root.left);
        System.out.println( root.data);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if( root == null ) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static boolean rootToNodePath(TreeNode root, int data, ArrayList<TreeNode> ans){
        if( root == null ){
            return false;
        }
        if( root.data == data ){
            ans.add( root );
            return true;
        }
        boolean res = rootToNodePath(root.left, data, ans) || rootToNodePath(root.right, data, ans);
        if( res) {
            ans.add( root );
        }
        return res;
    }

    public static ArrayList<TreeNode> nodeToRootPath( TreeNode root, int data ){
        if( root == null ){
            return new ArrayList<>();
        }
        if( root.data == data ){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        ArrayList<TreeNode> lAns = nodeToRootPath(root.left, data);
        if( lAns.size() != 0 ){
            lAns.add( root );
            return lAns ;
        }

        ArrayList<TreeNode> rAns = nodeToRootPath(root.right, data);
        if( rAns.size() != 0){
            rAns.add(root);
            return rAns;
        }

        return new ArrayList<>();
    }

    public static void LCA( TreeNode root, int d1, int d2){
        ArrayList<TreeNode> path1 = new ArrayList<>();
        rootToNodePath( root, d1, path1);
        int size1 = path1.size() - 1;

        ArrayList<TreeNode> path2 = new ArrayList<>();
        rootToNodePath( root, d2, path2);
        int size2 = path2.size() - 1;

        TreeNode LCA = null;
        while( size1 >= 0 && size2 >= 0 ) {
            if( path1.get(size1).data != path2.get(size2).data ){
                break;
            }
            LCA = path1.get(size1);

            size1--;
            size2--;
        }

        System.out.println( LCA.data );
    }

    public static void rootToLeaf(TreeNode root, ArrayList<ArrayList<TreeNode>> ans, ArrayList<TreeNode> smallAns){
        if( root == null) return;
        if( root.left == null && root.right == null){
            ArrayList<TreeNode> base = new ArrayList<>(smallAns);
            base.add(root);
            ans.add(base);
            return;
        }

        smallAns.add(root);
        rootToLeaf(root.left, ans, smallAns);
        rootToLeaf(root.right, ans, smallAns);
        smallAns.remove(smallAns.size()-1);
    }

    public static void rootToLeaf(TreeNode root){
        ArrayList<ArrayList<TreeNode>> ans = new ArrayList<>();
        ArrayList<TreeNode> smallAns = new ArrayList<>();
        rootToLeaf(root, ans, smallAns );
        for(ArrayList<TreeNode> myAns : ans){
            for(TreeNode node : myAns){
                System.out.print( node.data + " ");
            }
            System.out.println();
        }
    }

    public static void kDown(TreeNode root, int k, TreeNode block, ArrayList<TreeNode> ans){
        if( root == null || k < 0 || root == block ){
            return;
        }

        if( k == 0 ){
            ans.add(root);
            return;
        }

        kDown(root.left, k - 1, block, ans);
        kDown(root.right, k - 1, block, ans);
    }

    public static void kDown(TreeNode root){
        ArrayList<TreeNode> ans = new ArrayList<>();
        int k = 2;
        kDown(root, k, null, ans);
        for(TreeNode node : ans){
            System.out.print( node.data + " ");
        }
    }

    public static boolean nodeToRootPath(TreeNode root, int target, ArrayList<TreeNode> path){
        if( root == null ){
            return false;
        }
        if( root.data == target){
            path.add(root);
            return true;
        }

        boolean res = nodeToRootPath(root.left, target, path) || nodeToRootPath(root.right, target, path);
        if( res ){
            path.add(root);
        }
        return res;
    }

    public static void kDown(TreeNode root, TreeNode block, int k, ArrayList<TreeNode> ans){
        if( root == null || k < 0 || root == block){
            return;
        }
        if( k == 0 ){
            ans.add(root);
            return;
        }

        kDown(root.left, block, k - 1, ans);
        kDown(root.right, block, k - 1, ans);
    }

    public static void kFarAway(TreeNode root, int target, int K){
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath(root, target, path);

       ArrayList<TreeNode> ans = new ArrayList<>();
       TreeNode block = null;
       for(int i = 0; i < path.size(); i++){
           kDown(path.get(i), block, K - i, ans);
           block = path.get(i);
       }
       for( TreeNode node : ans){
           System.out.println( node.data );
       }
    }

    public static int kFarAway2(TreeNode root, int target, int k, ArrayList<TreeNode> ans){
        if( root == null ){
            return -1;
        }

        if( root.data == target ){
            kDown(root, null, k, ans);
            return 1;
        }

        int ld = kFarAway2( root.left, target, k, ans);
        if( ld!= -1){
            kDown(root, root.left, k - ld, ans);
            return ld+1;
        }

        int rd = kFarAway2( root.right, target, k, ans);
        if( rd!= -1){
            kDown(root, root.left, k - rd, ans);
            return rd+1;
        }
        return -1;
    }

    public static void kFarAway2(TreeNode root, int target, int K){
        ArrayList<TreeNode> ans = new ArrayList<>();

        kFarAway2(root, target, K, ans);

        for(TreeNode node : ans){
            System.out.println( node.data );
        }
    }


    public static void solve(){
        int[] arr = {10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        TreeNode root = constructTree(arr);
        // display(root);
        // System.out.println( size(root) );
        // System.out.println( height(root) );
        // System.out.println( maximum(root) );
        // System.out.println( minimum(root) );
        // System.out.println( find(root, 85) ); 
        // System.out.println( sum(root) );
        // preOrder(root);
        // inOrder(root);
        // postOrder(root);
        // ArrayList<TreeNode> ans = new ArrayList<>();
        // rootToNodePath(root, 110, ans);      
        // for(TreeNode node : ans){
        //     System.out.println( node.data );
        // }
        // ArrayList<TreeNode> ans = nodeToRootPath(root, 110);
        // for(TreeNode node : ans){
        //     System.out.println( node.data );
        // }
        // rootToLeaf(root);
        // LCA(root, 110, 100 );
        // kDown(root);
        // kFarAway(root, 110, 6);
        kFarAway2(root, 110, 2);
    }
    public static void main(String[] args){
        solve();
    }
}