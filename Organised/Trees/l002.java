public class l002{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node( int data ){
            this.data = data;
        }
    }

    public static Node constructTree( int[] arr, int si, int ei ){
        if( si > ei ) return null;

        int mid = ( si + ei )/2;

        Node node = new Node( arr[mid] );
        node.left = constructTree( arr, si, mid - 1 );
        node.right = constructTree( arr, mid + 1, ei );

        return node;
    }

    public static void display( Node root ){
        if( root == null ) return;

        StringBuilder sb = new StringBuilder("");
        sb.append( root.left == null ? "." : root.left.data );
        sb.append( " <-- " + root.data + " --> " );
        sb.append( root.right == null ? "." : root.right.data );

        System.out.println( sb.toString() );

        display( root.left );
        display( root.right );
    }

    public static int size( Node root ){
        return ( root == null ? 0 : size( root.left ) + size( root.right ) + 1 );
    }

    public static int height( Node root ){
        return root == null ? -1 : Math.max( height( root.left ), height( root.right ) ) + 1;
    }

    public static int maximum( Node root ){
        Node curr = root;

        while( curr.right != null ){
            curr = curr.right;
        }
        return curr.data;
    }

    public static int minimum( Node root ){
        Node curr = root;

        while( curr.left != null ){
            curr = curr.left;
        }
        return curr.data;
    }

    public static boolean find( Node root, int data ){
        Node curr = root;

        while( curr != null ){
            if( curr.data == data ){
                return true;
            }else if( curr.data > data ){
                curr = curr.left;
            }else curr = curr.right;
        }
        return false;
    }

    public static Node insertIntoBST( Node root, int val ){
        if( root == null ) return new Node( val );

        if( val < root.data ){
            root.left = insertIntoBST( root.left, val );
        }else root.right = insertIntoBST( root.right, val );

        return root;
    }

    public static Node deleteNode( Node root, int val ){
        if( root == null ) return null;

        if( val < root.data )
            root.left = deleteNode( root.left, val );
        else if( val > root.data )
            root.right = deleteNode( root.right, val );
        else{
            if( root.left == null || root.right == null ){
                Node node = root.left != null ? root.left : root.right;
                return root;
            }

            int mVal = maximum( root.left );
            root.data = mVal;
            root.left = deleteNode( root.left, mVal );
        }

        return root;
    }

    public static void allSolution( Node root, int data ){
        Node curr = null;
        Node pred = null;
        Node succ = null;

        while( curr != null ){
            if( curr.data == data ){
                if( curr.left != null ){
                    pred = curr.left;
                    while( pred.right != null )
                        pred = pred.right;
                }

                if( curr.right != null ){
                    succ = curr.right;
                    while( succ.left != null )
                        succ = succ.left;
                }
                break;
            }
            else if( curr.data > data ){
                succ = curr;
                curr = curr.left;
            }
            else{
                pred = curr;
                curr = curr.right;
            }
        }

        System.out.println( pred.data + " -- " + succ.data );
    }

    public static void allSolution( Node root ){
        allSolution( root, 120 );

    }

    public static void print(){
        
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for( int i = 0; i < arr.length; i++ ){
            arr[i] = ( i + 1 ) * 10;
        }

        Node root = constructTree( arr, 0, arr.length - 1 );
        // display( root );
        // System.out.println( find( root,70 ) );
        // root = insertIntoBST( root, 75 );
        // System.out.println( find( root, 75 ) );

        // allSolution( root );
        // System.out.println( 35 ^ 35 ^ 67 ^ 52 ^67  );
        print();
    }
}