public class Solution{

    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        public Node( int data )
        {
            this.data = data;
        }
    }

    public static Node constructTree( int[] arr, int low, int high )
    {
        if( low > high ) return null;

        int mid = low + ( high - low )/2;

        Node node = new Node( arr[mid] );
        node.left = constructTree( arr, low, mid - 1 );
        node.right = constructTree( arr, mid + 1, high );

        return node;
    }

    public static int getMin( Node root )
    {
        if( root == null ) return (int)1e8;

        Node curr = root;
        while( curr.left != null )
        {
            curr = curr.left;
        }
        return curr.data;
    }


    public static void solve()
    {
        int[] arr = new int[14];
        for( int i = 0; i < arr.length; i++ ) arr[i] = i * 10;
        Node root = constructTree( arr, 0, arr.length - 1 );

        System.out.println( getMin( root ) );
    }
    public static void main( String[] args )
    {
        solve();
    }
}