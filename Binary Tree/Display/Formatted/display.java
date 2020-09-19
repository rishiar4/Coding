public class display
{
    // Function used to display 
    // left.data <-- data --> right.data 
    
    public static void display( Node root )
    {
        if( root == null ) return;

        StringBuilder sb = new StringBuilder();
        sb.append( root.left == null ? "." : root.left.data );
        sb.append( " <-- " + root.data + " --> " );
        sb.append( root.right == null ? "." : root.right.data );
        System.out.println( sb );

        display( root.left );
        display( root.right );
    }

}