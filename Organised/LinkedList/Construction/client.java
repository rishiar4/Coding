public class client{
    public static void main(String[] args) throws Exception{
        LinkedList ll = new LinkedList();

        for( int i = 1; i <= 10; i++ ){
            ll.addFirst( i * 10 );
        }

        for( int i = 1; i <= 10; i++ ){
            ll.addLast( - i * 10 );
        }


        ll.addAt( -200, 2 );

        System.out.println( ll );
        // System.out.println( ll.getFirst() );
        // System.out.println( ll.getLast() );
        // System.out.println( ll.getAt( 3 ) );

        // System.out.println( ll.removeFirst() );
        // System.out.println( ll.removeLast() );
        // System.out.println( ll.removeLast() );
        System.out.println( ll.removeAt( 2 ) );
        // System.out.println( ll.removeAt( 20 ) );

        // removeLast && removeAt 

        System.out.println( ll );
    }
}