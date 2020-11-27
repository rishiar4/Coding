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
        if( idx >= arr.length || arr[idx] == -1 ){
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

        StringBuilder sb = new StringBuilder();

        sb.append( ( root.left == null ? "." : root.left.data + "" ) );
        sb.append( " <-- " + root.data + " --> " );
        sb.append( ( root.right == null ? "." : root.right.data + "" ) );
        System.out.println( sb );

        display( root.left );
        display( root.right );
    }

    public static void inOrder( Node root ){
        if( root == null ) return;

        inOrder( root.left );

        System.out.print( root.data + " ");

        inOrder( root.right );
    }

    public static void main( String[] args ){
        int[] arr = { 10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1 };

        Node root = constructTree( arr );

        display( root );
        inOrder( root );
    }
}