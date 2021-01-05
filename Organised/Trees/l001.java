import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
        if( rAns != -1 ){
            kDown( root, root.right, k - rAns, ans );
            return rAns + 1;
        }
        return -1;
    }

    public static void kFar( Node root){
        ArrayList<Node> ans = new ArrayList<>();
        // kFar( root, ans, 50, 5 );
        kFar2( root, 50, 2, ans );

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

    public static int diameter( Node root ){
        if( root == null ) return 0;
        
        int ld = diameter( root.left );
        int rd = diameter( root.right );


        int lh = height( root.left );
        int rh = height( root.right );

        return Math.max( Math.max(ld,rd), lh + rh + 2 );
    }

    public static int[] diameter_02( Node root ){
        if( root == null ) return new int[]{0,-1};

        int[] lRes = diameter_02( root.left );
        int[] rRes = diameter_02( root.right );

        int dia = Math.max( Math.max( lRes[0], rRes[0] ), lRes[1] + rRes[1] + 2 );
        int hei = Math.max( lRes[1], rRes[1] ) + 1;

        return new int[]{ dia, hei };

    }

    static int diaAns = 0;
    public static int diameter_03( Node root ){
        if( root == null ) return -1;

        int lH = diameter_03( root.left );
        int rH = diameter_03( root.right );

        diaAns = Math.max( diaAns, lH + rH + 2 );

        return Math.max( lH, rH ) + 1;
    }

    public static void Diameter( Node root ){
        // Two farther points.
        // When stretching the point which has the whole tree coverred.
        // Proper Boundary if the nodes of tree are stretched.

        // left main hoga, right main hoga, ya pooora ho sakta hai 

        // System.out.println( diameter( root ) );
        // System.out.println( diameter_02( root )[0] );
        // diameter_03( root );
        // System.out.println( diaAns );

    }

    // BFS ===> LEVEL ORDER.

    public static void BFS_01( Node root ){
        if( root == null ) return;

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );

        while( qu.size() != 0 ){
            Node vtx = qu.remove();

            System.out.print( vtx.data + " ");

            if( vtx.left != null ) qu.add( vtx.left );
            if( vtx.right != null ) qu.add( vtx.right );
        }
    }

    public static void BFS_02( Node root ){
        if( root == null ) return;

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );
        qu.add( null );
        
        while( qu.size() != 1 ){
            Node vtx = qu.remove();
            System.out.print( vtx.data + " ");
            if( vtx.left != null ) qu.add( vtx.left );
            if( vtx.right != null ) qu.add( vtx.right );

            if( qu.peek() == null ){
                System.out.println();
                qu.remove();
                qu.add( null );
            }
        }  
    }

    public static void BFS_03( Node root ){
        if( root == null ) return;

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );

        int level = 0;

        while( qu.size() != 0 ){
            System.out.print( level + " " );
            int size = qu.size();
            while( size > 0 ){
                Node vtx = qu.remove();
                System.out.print( vtx.data + " ");

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                size--;
            }
            System.out.println();
            level++;
        }
    }

    public static void BFS( Node root ){
        // BFS_01( root );
        // BFS_02( root );
        // BFS_03( root );
    }

    public static ArrayList<Integer> leftInterview( Node root ){
        // if( root == null ) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );

        while( qu.size() != 0 ){
            ans.add( qu.peek().data );
            int size = qu.size();
            while( size > 0 ){
                Node vtx = qu.remove();

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );
                size--;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> rightInterview( Node root ){
        // if( root == null ) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> qu = new LinkedList<>();
        qu.add( root );

        while( qu.size() != 0 ){
            int size = qu.size();
            while( size > 0 ){
                Node vtx = qu.remove();

                if( vtx.left != null ) qu.add( vtx.left );
                if( vtx.right != null ) qu.add( vtx.right );

                if( size == 1 ) ans.add( vtx.data );  
                size--;
            }
        }
        return ans;
    }

    public static void width( Node root, int level, int[] maxMin ){
        if( root == null ) return;

        maxMin[0] = Math.max( maxMin[0], level );
        maxMin[1] = Math.min( maxMin[1], level );

        width( root.left, level - 1, maxMin );
        width( root.right, level + 1, maxMin );
    }

    // public static class pair{
    //     Node node = null;
    //     int val = 0;

    //     pair( Node node, int val ){
    //         this.node = node;
    //         this.val = val;
    //     }
    // }

    public static ArrayList<pair> lView( Node root ){
        if( root == null ) new ArrayList<pair>();
        ArrayList<pair> ans = new ArrayList<>();

        Queue<pair> qu = new LinkedList<>();
        qu.add( new pair( root, 0  ));

        int level = 0;

        while( qu.size() != 0 ){
            int size = qu.size();
            while( size > 0 ){
                pair vtx = qu.remove();

                if( ans.size() == level ) ans.add( vtx );
                else if( vtx.val < ans.get(level).val ) ans.set( level, vtx );

                if( vtx.node.left != null ) qu.add( new pair( vtx.node.left, vtx.val - 1 ) );
                if( vtx.node.right != null ) qu.add( new pair( vtx.node.right, vtx.val + 1 ) );

                size--;
            }
            level++;
        }
        return ans;
    }

    public static ArrayList<pair> rView( Node root ){
        ArrayList<pair> ans = new ArrayList<>();
        Queue<pair> qu = new LinkedList<>();
        qu.add( new pair( root, 0 ) );

        int level = 0;
        while( qu.size() != 0 ){
            int size = qu.size();
            while( size > 0 ){
                pair vtx = qu.remove();
                
                if( level == ans.size() ) ans.add( vtx );
                else if( ans.get(level).val < vtx.val ) ans.set( level, vtx );
                if( vtx.node.left != null ) qu.add( new pair( vtx.node.left, vtx.val - 1 )  );
                if( vtx.node.right != null ) qu.add( new pair( vtx.node.right, vtx.val + 1 )  );
                size--;
            }
            level++;
        }

        return ans;
    }


    public static class pair{
        Node node = null;
        int val = 0;

        pair( Node node, int val ){
            this.node = node;
            this.val = val;
        }
    }


    public static void verticalOrder( Node root ){
        if( root == null ) return;

        int[] maxMin = new int[2];
        width( root, 0, maxMin );
        int n = maxMin[0] - maxMin[1] + 1;
        Queue<pair> qu = new LinkedList<>();
        qu.add( new pair( root, -maxMin[1] ) );

        ArrayList<Integer>[] ans = new ArrayList[n];
        for( int i = 0; i < n; i++ ) ans[i] = new ArrayList<>();

        while( qu.size() != 0 ){
            int size = qu.size();
            while( size > 0 ){
                pair vtx = qu.remove();

                ans[vtx.val].add( vtx.node.data );

                if( vtx.node.left != null ) qu.add( new pair( vtx.node.left, vtx.val - 1 ) );
                if( vtx.node.right != null ) qu.add( new pair( vtx.node.right, vtx.val + 1 ) );
                size--;
            }
        }

        for( int i = 0; i < n; i++ ) System.out.println( ans[i] );
    }



    public static void verticalSum( Node root ){
        if( root == null ) return;
        int[] maxMin = new int[2];
        width( root, 0, maxMin );
        int n = maxMin[0] - maxMin[1] + 1;
        int[] ans = new int[n];

        Queue<pair> qu = new LinkedList<>();
        qu.add( new pair( root, -maxMin[1] ) );

        while( qu.size() != 0 ){
            int size = qu.size();
            while( size > 0 ){
                pair vtx = qu.remove();

                ans[vtx.val] += vtx.node.data;

                if( vtx.node.left != null ) qu.add( new pair( vtx.node.left, vtx.val - 1 ) );
                if( vtx.node.right != null ) qu.add( new pair( vtx.node.right, vtx.val + 1 ) );
                size--;
            }
        }

        for( int a : ans ) System.out.print( a + " ");
    }

    public static void bottomView( Node root ){
        if( root == null ) return;
        int[] maxMin = new int[2];
        width( root, 0, maxMin );
        int n = maxMin[0] - maxMin[1] + 1;
        int[] ans = new int[n];

        Queue<pair> qu = new LinkedList<>();
        qu.add( new pair( root, -maxMin[1] ) );

        while( qu.size() != 0 ){
            int size = qu.size();
            while( size > 0 ){
                pair vtx = qu.remove();

                ans[vtx.val] = vtx.node.data;

                if( vtx.node.left != null ) qu.add( new pair( vtx.node.left, vtx.val - 1 ) );
                if( vtx.node.right != null ) qu.add( new pair( vtx.node.right, vtx.val + 1 ) );
                size--;
            }
        }

        for( int a : ans ) System.out.print( a + " ");
    }

    public static void topView( Node root ){
        if( root == null ) return;

        int[] maxMin = new int[2];
        width( root, 0, maxMin );
        int n = maxMin[0] - maxMin[1] + 1;

        Integer[] ans = new Integer[n];

        Queue<pair> qu = new LinkedList<>();
        qu.add( new pair( root, -maxMin[1] ) );

        while( qu.size() != 0 ){
            int size = qu.size();
            while( size > 0 ){
                pair vtx = qu.remove();

                if( ans[vtx.val] == null ) ans[vtx.val] = vtx.node.data;

                if( vtx.node.left != null ) qu.add( new pair( vtx.node.left, vtx.val - 1 ) );
                if( vtx.node.right != null ) qu.add( new pair( vtx.node.right, vtx.val + 1 ) );
                size--;
            }
        }

        for( int a : ans ) System.out.print( a + " ");
    }

    public static void widthDiagonal( Node root, int level, int[] res ){
        if( root == null ) return;

        res[0] = Math.min( res[0], level );
        
        widthDiagonal( root.left, level - 1, res );
        widthDiagonal( root.right, level, res );
    }

    public static void diagnalView( Node root, int level, ArrayList<Integer>[] ans ){
        if( root == null ) return;

        ans[level].add( root.data );

        diagnalView( root.left, level - 1, ans );
        diagnalView( root.right, level, ans );
    }

    public static void diagnalView( Node root ){
        int[] res = new int[1];
        widthDiagonal( root, 0, res );

        int n = 0 - res[0] + 1;
        ArrayList<Integer>[] ans = new ArrayList[n];
        for( int i = 0; i < n; i++ ) ans[i] = new ArrayList<>();

        diagnalView( root, -res[0], ans );

        for( int i = 0; i < n; i++ ){
            System.out.println( ans[i] );
        }
    }

    public static void Views( Node root ){
        // System.out.println( leftInterview( root ) );
        // System.out.println( rightInterview( root ) );

        // int[] maxMin = new int[2];
        // width( root, 0, maxMin );
        // System.out.println( maxMin[0] - maxMin[1] + 1 );

        // ArrayList<pair> ans = lView( root );
        // ArrayList<pair> ans = rView( root );
        // for( pair a : ans ) System.out.print( a.node.data + " ");

        // verticalOrder( root );
        // verticalSum( root );
        // bottomView( root );
        // topView( root );

        diagnalView( root );
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

        // burningTree( root );

        // Diameter( root );

        // BFS( root );
        Views( root );
    }
}