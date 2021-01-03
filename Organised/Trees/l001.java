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
        if( idx == arr.length || arr[idx] == -1 ){
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
        return root == null ? -1 : Math.max( height( root.left ), height( root.right ) + 1 );
    }

    public static boolean find( Node root, int data ){
        if( root == null ) return false;

        if( root.data == data ) return true;

        return find( root.left, data ) || find( root.right, data );
    }

    public static boolean nodeToRootPath( Node root, ArrayList<Node> ans, int data ){
        if( root == null ) return false;

        if( root.data == data ){
            ans.add( root );
            return true;
        }

        boolean res = nodeToRootPath( root.left, ans, data ) || nodeToRootPath( root.right, ans, data );
        if( res ){
            ans.add( root );
        }

        return res;
    }

    public static boolean rootToNodePath( Node root, ArrayList<Node> ans, int data ){
        if( root == null ) return false;

        if( root.data == data ){
            ans.add( root );
            return true;
        }

        ans.add( root );
        boolean res = rootToNodePath( root.left, ans, data ) || rootToNodePath( root.right, ans, data );
        if( !res ){
            ans.remove( ans.size() - 1 );
        }

        return res;
    }

    public static ArrayList<Node> nodeToRootPath( Node root, int data ){
        if( root == null ) return null;

        if( root.data == data ){
            ArrayList<Node> ans = new ArrayList<>();
            ans.add( root );
            return ans;
        }

        ArrayList<Node> left = nodeToRootPath( root.left, data );
        if( left != null ){
            left.add( root );
            return left;
        }

        ArrayList<Node> right = nodeToRootPath( root.right, data );
        if( right != null ){
            right.add( root );
            return right;
        }

        return null;
    }

    public static Node LCA( Node root, int data1,int data2 ){
        if( root == null ) return null;

        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        nodeToRootPath( root, list1, data1 );
        nodeToRootPath( root, list2, data2 );

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        Node LCA = null;
        while( i >= 0 && j >= 0 ){
            if( list1.get(i) == list2.get(j) ) LCA = list1.get(i);

            i--;
            j--;
        }

        return LCA;
    }

    public static void kDown( Node root, Node blockage, int k, ArrayList<Node> ans ){
        if( root == null || root == blockage || k < 0 ){
            return;
        }
        if( k == 0 ){
            ans.add( root );
            return;
        }

        kDown( root.left, blockage,  k - 1, ans );
        kDown( root.right, blockage,  k - 1, ans );

    }

    public static void kFar( Node root, ArrayList<Node> ans, int data, int k ){
        ArrayList<Node> list = new ArrayList<>();
        nodeToRootPath( root, list, data );

        Node blockage = null;
        for( int i = 0; i < list.size(); i++ ){
            kDown( list.get(i), blockage, k - i, ans );
            blockage = list.get(i);
        }
    }

    public static int kFar2( Node root, int data, int k, ArrayList<Node> ans ){
        if( root == null ) return -1;

        if( root.data == data ){
            kDown( root, null, k, ans );
            return 1;
        }

        int lAns = kFar2( root.left, data, k, ans );
        if( lAns != -1 ){
            kDown( root, root.left, k - lAns, ans );
            return lAns + 1;
        }

        int rAns = kFar2( root.right, data, k, ans );
        if( lAns != -1 ){
            kDown( root, root.right, k - rAns, ans );
            return rAns + 1;
        }
        return -1;
    }

    public static void kFar( Node root){
        ArrayList<Node> ans = new ArrayList<>();
        // kFar( root, ans, 50, 5 );
        kFar2( root, 30, 2, ans );

        for( Node nn : ans ) System.out.print( nn.data + " " );
    }

    public static void burnTree( Node root, Node block, int time, ArrayList<ArrayList<Node>> ans ){
        if( root == null || root == block ){
            return;
        }

        if( ans.size() == time ) ans.add( new ArrayList<>() );
        ans.get( time ).add( root );

        burnTree( root.left, block, time + 1, ans );
        burnTree( root.right, block, time + 1, ans );
    }

    public static void burningTree( Node root ){
        if( root == null ) return;

        ArrayList<ArrayList<Node>> ans = new ArrayList<>();
        ArrayList<Node> list = new ArrayList<>();
        nodeToRootPath( root, list, 60 );

        Node block = null;
        for( int i = 0; i < list.size(); i++ ){
            burnTree( list.get(i), block, i, ans );
            block = list.get( i );
        }

        for( ArrayList<Node> a : ans ){
            for( Node nn : a ) System.out.print( nn.data + " ");
            System.out.println();
        }
    }
    
    public static void main( String[] args ){
        int[] arr = {10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree( arr );
        // display( root );

        // System.out.println( "Size " + size( root ) );
        // System.out.println( "Height " + height( root ) );
        // System.out.println( "Find " + find( root, 70 ) );

        // ArrayList<Node> ans = new ArrayList<>();
        // nodeToRootPath( root, ans, 120 );
        // for( Node node : ans ) System.out.print( node.data + " ");

        // ArrayList<Node> ans = new ArrayList<>();
        // rootToNodePath( root, ans, 120 );
        // for( Node node : ans ) System.out.print( node.data + " ");

        // ArrayList<Node> ans = nodeToRootPath( root, 120 );
        // for( Node node : ans ) System.out.print( node.data + " ");
        // System.out.println();

        // Node LCA = LCA( root, 90, 80 );
        // System.out.println( "LCA ---> " + LCA.data );

        // kFar( root );

        burningTree( root );
    }
}