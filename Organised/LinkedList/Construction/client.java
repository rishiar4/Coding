public class client{
    public static void main(String[] args) throws Exception{
        LinkedList ll = new LinkedList();

        for( int i = 1; i <= 10; i++ ){
            ll.addFirst( i * 10 );
        }
        System.out.println( ll );
        for( int i = 0; i < 5; i++ ){
            ll.removeFirst();
        }
        System.out.println( ll.getFirst() );
        System.out.println( ll );
    }
}