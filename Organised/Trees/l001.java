import java.util.ArrayList;
public class l001{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node( int data ){
            this.data = data;
        }
    }

    static int idx = 0;
    public static Node constructTree( int[] arr ){
        if( idx >= arr.length || arr[ idx ] == -1 ){
            idx++;
            return null;
        }
        Node node = new Node( arr[idx++] );
        node.left = constructTree( arr );
        node.right = constructTree( arr );

        return node;
    }

    public static void display( Node root ){
        if( root == null ) return;

        StringBuilder sb = new StringBuilder("");
        sb.append( root.left == null ? "." : root.left.data );
        sb.append( " <-- " + root.data + " --> ");
        sb.append( root.right == null ? "." : root.right.data );

        System.out.println( sb.toString() );

        display( root.left );
        display( root.right );
    }

    public static int size( Node root ){
        return root == null ? 0 : size( root.left ) + size( root.right ) + 1;
    }

    public static int height( Node root ){
        return root == null ? -1 : Math.max( height(root.left) , height(root.right) ) + 1;
    }

    public static boolean find( Node root, int data ){
        if( root == null ) return false;

        if( root.data == data ) return true;

        boolean res = find( root.left, data ) || find( root.right, data ); 

        return res;
    }

    public static boolean nodeToRootPath( Node root, int data, ArrayList<Node> ans ){
        if( root == null ) return false;

        if( root.data == data ){
            ans.add( root );
            return true;
        }

        boolean res = nodeToRootPath( root.left, data, ans ) || nodeToRootPath( root.right, data, ans );

        if( res ) ans.add( root );

        return res;
    }

    public static void nodeToRootPath( Node root ){
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath( root, 120, ans );
        for( Node node : ans ){
            System.out.print( node.data + " ");
        }
    }

    public static boolean rootToNodePath( Node root, int data, ArrayList<Node> ans ){
        if( root == null ) return false;

        if( root.data == data ){
            ans.add( root );
            return true;
        }

        ans.add( root );

        boolean res = rootToNodePath( root.left, data, ans ) || rootToNodePath( root.right, data, ans );
        if( !res ){
            ans.remove( ans.size() - 1 );
        }

        return res;
    }

    public static void rootToNodePath( Node root ){
        ArrayList<Node> ans = new ArrayList<>();
        rootToNodePath( root, 120, ans );
        for( Node node : ans ){
            System.out.print( node.data + " ");
        }
    }

    public static int LCA( Node root, int data1, int data2 ){
        if( root == null ) return 0;

        ArrayList<Node> ans1 = new ArrayList<>();
        ArrayList<Node> ans2 = new ArrayList<>();

        nodeToRootPath( root, data1, ans1 );
        nodeToRootPath( root, data2, ans2 );

        int i = ans1.size() - 1;
        int j = ans2.size() - 1;

        Node LCA = null;
        while( i >= 0 && j >= 0 ){
            if( ans1.get(i) == ans2.get(j) ) LCA = ans1.get(i);

            i--;
            j--;
        }

        return LCA.data;
    }

    public static void kDown( Node root, Node block, int k, ArrayList<Integer> ans ){
        if( root == null || root == block || k < 0 ) return;

        if( k == 0 ){
            ans.add( root.data );
            return;
        }

        kDown( root.left, block, k - 1, ans );
        kDown( root.right, block, k - 1, ans );
    }

    public static void kFar( Node root, int data, int k ){
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath( root, data, ans );

        ArrayList<Integer> fAns = new ArrayList<>();

        Node blockage = null;
        for( int i = 0; i < ans.size(); i++ ){
            kDown( ans.get(i), blockage, k - i, fAns );
            blockage = ans.get(i);
        }
        System.out.println( fAns );
    }

    public static void kDown_( Node root, int k, Node blockage, ArrayList<Integer> ans ){
        if( root == null || root == blockage || k < 0 ) return;

        if( k == 0 ){
            ans.add( root.data );
            return;
        }

        kDown_( root.left, k - 1, blockage, ans );
        kDown_( root.right, k - 1, blockage, ans );
    }


 
    public static int kFar2( Node root, int data, int k, ArrayList<Integer> ans ){
        if( root == null ) return -1;

        if( root.data == data ){
            kDown_( root, k, null, ans );
            return 1;
        }

        int lRes = kFar2( root.left, data, k, ans );
        if( lRes != -1 ){
            kDown_( root, k - lRes, root.left, ans );
            return lRes + 1;
        }
        
        int rRes = kFar2( root.right, data, k, ans );
        if( rRes != -1 ){
            kDown_( root, k - rRes, root.right, ans );
            return rRes + 1;
        }

        return -1;
    }


    public static void kFar2( Node root ){
        ArrayList<Integer> ans = new ArrayList<>();
        kFar2( root, 60, 4, ans );
        System.out.println( ans );
    }

    public static void solve(){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree( arr );
        // display( root );
        // System.out.println( size(root) );
        // System.out.println( height(root) );
        // System.out.println( find( root, 700) );
        // nodeToRootPath( root );
        // rootToNodePath( root );
        // System.out.println( LCA( root, 40, 90 ) );
        // ArrayList<Integer> ans = new ArrayList<>();
        // kDown( root, null, 2, ans );
        // System.out.println( ans );

        // kFar( root, 60, 3 );
        kFar2( root );



        // kDown( root, 10, )
    }
    public static void main(String[] args) {
        solve();

    }
}