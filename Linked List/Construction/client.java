public class client{
    public static void main(String[] args) throws Exception{
        LinkedList ll = new LinkedList();

        for( int i = 0; i < 10; i++ )
        {
            ll.addFirst( i * 10 );
        }

        ll.addFirst(-100) ;

        ll.addLast(-1000);

        ll.addAt( 2, 99 );

        System.out.println( ll );

        // System.out.println( ll.removeLast() );

        System.out.println( ll.removeAt(2) );

        System.out.println( ll );
        
        // System.out.println( ll.getFirst() );

        // System.out.println( ll.getAt( 2 ) );

        // System.out.println( ll.getLast() );


    }
}